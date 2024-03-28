# 그래프 이론(Graph Theory)

추가적으로 다룰 알고리즘 및 자료구조 : 크루스칼 알고리즘 / 위상 정렬 알고리즘 / 서로소 집합 자료구조

---

## 서로소 집합(Disjoint Sets)

수학에서 서로소 집합이란 **공통 원소가 없는 두 집합**을 말한다.

서로소 집합 자료구조란 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조라고 할 수 있다.

서로소 집합 자료구조는 union과 find 이 2개의 연산으로 조작할 수 있다.

union(합집합) 연산은 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산이다. find(찾기) 연산은 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산이다.

---

## 서로소 집합 자료구조

```python
import sys
input = sys.stdin.readline

def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    # parent[x] : x의 루트 노드
    return parent[x]

def unionParent(parent, a, b):
    a = findParent(parent, a)
    b = findParent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

V, E = map(int, input().split())
parent = [0] * (V+1)

for i in range(1, V+1):
    parent[i] = i

for i in range(E):
    a, b = map(int, input().split())
    unionParent(parent, a, b)

print("각 원소가 속한 집합: ", end = " ")
for i in range(1, V+1):
    print(findParent(parent, i), end=" ")

print()

print("부모 테이블: ", end=" ")
for i in range(1, V+1):
    print(parent[i], end=" ")
```

- 루트 노드를 찾기 위해 재귀적으로 호출을 함(findParent)

- 두 원소가 속한 집합을 합치는 연산(unionParent), 큰 노드의 루트 노드를 작은 노드의 루트 노드로 갱신함

---

## 신장 트리(Spanning Tree)

신장 트리는 그래프 알고리즘 문제로 자주 출제되는 문제 유형이다. 기본적으로 신장 트리란, 하나의 그래프가 있을 때, 모든 노드를 포함하되 사이클을 형성하지 않는 부분 그래프를 말한다.

위의 신장 트리에서 최소 비용으로 만들 수 있는 신장 트리를 찾는 알고리즘을 최소 신장 트리 알고리즘, 크루스칼 알고리즘이라고 한다.

```python
import sys
input = sys.stdin.readline

def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]

def unionParent(parent, a, b):
    a = findParent(parent, a)
    b = findParent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

V, E = map(int, input().split())
parent = [0] * (V+1)

for i in range(1, V+1):
    parent[i] = i

# 간선 정보
edges = []
# 최종 비용
result = 0
for _ in range(E):
    a, b, cost = map(int, input().split())
    # 최소 비용 순으로 정렬을 하기 위해 cost를 맨 첫 번째에 배치
    edges.append((cost, a, b))
edges.sort()

for edge in edges:
    cost, a, b = edge
    if findParent(parent, a) != findParent(parent, b):
        unionParent(parent, a, b)
        result += cost 
print(result)       
```

---

## 위상 정렬(Topology Sort)

위상 정렬은 정렬 알고리즘의 일종이다. 위상 정렬은 **순서가 정해진 일련의 작업들을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘**이다.

쉽게 말해 스타크래프트에서의 스트럭쳐 테크 트리라고 생각하면 된다.(Ex. 배럭을 지어야 아카데미를 지을 수 있음)

방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대로 나열하는 것'이다.

그래프 상에서 선후 관계가 있다면 위상 정렬을 수행하여 어떤 것을 먼저 할지 전체 순서를 계산할 수 있다.

위상 정렬 알고리즘에 대해서 알기 전에 먼저 진입 차수라는 개념을 알아야 하는데 진입 차수는 특정한 노드로 들어오는 간선의 개수를 의미한다.

진입 차수가 0이라는 말은 먼저 작업을 할 수 있다는 것을 말한다.

```python
import sys
input = sys.stdin.readline
from collections import deque

V, E = map(int, input().split())
# 진입 차수 배열
degree = [0] * (V+1)
# 인접 리스트(다익스트라, 위상 정렬)
# 인접 행렬(플로이드 워셜)
graph = [[] for _ in range(V+1)]

for _ in range(E):
    a, b = map(int, input().split())
    # a → b로 가는 것 : 따라서 b의 진입차수가 증가하는 것   
    graph[a].append(b)
    degree[b] += 1

def topologySort():
    result = [] # 알고리즘 수행 결과
    q = deque()

    # 처음 순회할 때 진입차수가 0인 것들 먼저 큐에 넣기
    for i in range(1, V+1):
        if degree[i] == 0:
            q.append(i)
    
    # 큐가 빌 때까지 반복
    while q:
        now = q.popleft()
        result.append(now)
        # 해당 원소와 인접한 노드들의 진입차수에서 1씩 빼기
        for i in graph[now]:
            degree[i] -= 1
            if degree[i] == 0:
                q.append(i)
    
    # 위상 정렬 수행 결과 출력
    for i in result:
        print(i, end=" ")

topologySort()
```

