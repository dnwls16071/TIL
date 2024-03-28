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

---

### ▣ 실전 문제 : 팀 결성

학교에서 학생들에게 0번부터 N번까지의 번호를 부여했다.

처음에는 모든 학생이 서로 다른 팀으로 구분되어, 총 N+1개의 팀이 존재한다.

이 때, 선생님은 '팀 합치기'연산과 '같은 팀 여부 확인'연산을 사용할 수 있다.

```bash
[1]. '팀 합치기'연산은 두 팀을 합치는 연산이다.

[2]. '같은 팀 여부 확인'연산은 특정한 두 사람이 같은 팀에 속하는지를 확인하는 연산이다.
```

### ▣ 입력 조건

[1]. 첫째 줄에 N, M이 주어진다. M은 입력으로 주어지는 연산의 개수이다.(1 ≤ N, M ≤ 100,000)

[2]. 다음 M개의 줄에는 각각의 연산이 주어진다.

[3]. '팀 합치기'연산은 0 a b 형태로 주어진다. 이는 a번 학생이 속한 팀과 b번 학생이 속한 팀을 합친다는 의미이다.

[4]. '같은 팀 여부 확인'연산은 1 a b 형태로 주어진다. 이는 a번 학생과 b번 학생이 같은 팀에 속하는지를 확인하는 연산이다.

[5]. a와 b는 N이하의 양의 정수다.

### ▣ 출력 조건

'같은 팀 여부 확인'연산에 대하여 한 줄에 하나씩 YES 혹은 NO를 출력한다.

### ▣ 입력 예시

7 8

0 1 3

1 1 7

0 7 6

1 7 1

0 3 7

0 4 2

0 1 1

1 1 1

### ▣ 출력 예시

NO

NO

YES

```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
parent = [0] * (N+1)
for i in range(1, N+1):
    parent[i] = i

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

for _ in range(M):
    num, a, b = map(int, input().split())
    if num == 0:
        unionParent(parent, a, b)
    elif num == 1:
        if findParent(parent, a) == findParent(parent, b):
            print("YES")
        else:
            print("NO")
```

### ▣ 실전 문제 : 도시 분할 게획

동물원에서 막 탈출한 원숭이 한 마리가 세상 구경을 하고 있다. 

어느 날 원숭이는 '평화로운 마을'에 잠시 머물렀는데 마침 마을 사람들은 도로 공사 문제로 머리를 맞대고 회의 중이었다.

마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다. 

길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 그리고 길마다 길을 유지하는데 드는 유지비가 있다.

마을의 이장은 마을을 2개의 분리된 마을로 분할할 계획을 세우고 있다. 마을이 너무 커서 혼자서는 관리할 수 없기 때문이다. 마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 마을에는 집이 하나 이상 있어야 한다.

그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 이것을 구하는 프로그램을 작성하시오.

### ▣ 입력 조건

[1]. 첫째 줄에 집의 개수 N, 길의 개수 M이 주어진다. 

[2]. N은 2 이상 100,000 이하인 정수이고, M은 1 이상 1,000,000 이하인 정수이다.

[3]. 그 다음 줄부터 M줄에 걸쳐 길의 정보가 A, B, C 3개의 정수로 공백으로 구분되어 주어지는데 A번 집과 B번 집을 연결하는 길의 유지비가 C(1 ≤ C ≤ 1,000) 라는 뜻이다.

### ▣ 출력 조건

첫째 줄에 길을 없애고 남은 유지비 합의 최솟값을 출력한다.

### ▣ 입력 예시

7 12

1 2 3

1 3 2

3 2 1

2 5 2

3 4 4

7 3 6

5 1 5

1 6 2

6 4 1

6 5 3

4 5 3

6 7 4

### ▣ 출력 예시

8

```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
parent = [0] * (N+1)
for i in range(1, N+1):
    parent[i] = i

def unionParent(parent, a, b):
    a = findParent(parent, a)
    b = findParent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
    
def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]

edges = []
for _ in range(M):
    A, B, C = map(int, input().split())
    edges.append((C, A, B))
edges.sort()

result = 0
# 가장 유지비가 많이 나온 경우
last = 0
for edge in edges:
    cost, a, b = edge
    if findParent(parent, a) != findParent(parent, b):
        unionParent(parent, a, b)
        result += cost
        last = cost
print(result - last)
```

- 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다.(사이클을 형성하지 않는다.)

- 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다.

- 결과적으로 나머지 길들의 유지비의 합을 최소가 되게 하는 것으로 유지비가 가장 많이 나오는 경우 연결을 끊어 2개의 분리된 마을로 분할한다.

---

