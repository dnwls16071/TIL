# 최단 경로(Shortest Path)

최단 경로(Shortest Path) 알고리즘이란 말 그대로 가장 짧은 경로를 찾는 알고리즘이다. 그래서 '길 찾기' 문제라고도 불린다.

최단 경로 알고리즘 유형에는 다양한 종류가 있는데 상황에 맞는 효율적인 알고리즘이 이미 정립되어 있다.

최단 경로 문제는 보통 **그래프**를 이용해 표현하는데 각 지점은 그래프에서 노드로 표현되고 지점 간 연결된 도로는 그래프에서 **간선**으로 표현한다.

---

## 다익스트라 최단 경로 알고리즘(Dijkstra)

다익스트라 최단 경로 알고리즘은 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구하는 알고리즘이다.

다익스트라 최단 경로 알고리즘은 '음의 간선'이 없을 때, 정상적으로 동작한다. 음의 간선이란 0보다 작은 값을 가지는 간선을 의미하는데 현실 세계의 길은 음의 간선으로 표현되지 않는다.

따라서 다익스트라 알고리즘은 실제로 GPS 소프트웨어의 기본 알고리즘으로 채택되곤 한다.

다익스트라 최단 경로 알고리즘을 단계별로 설명하면 다음과 같다.

```bash
[1]. 출발 노드를 설정한다. ▶ 출발 노드(start)

[2]. 최단 거리 테이블을 초기화한다. ▶ 최단 거리 테이블(1차원 배열)

[3]. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다. ▶ 방문 여부를 따지는 배열 필요

[4]. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산해 최단 거리 테이블을 갱신한다.

[5]. 위 과정에서 [3], [4]번을 반복한다.
```

다익스트라 알고리즘은 엄연히 그리디 알고리즘으로 분류가 된다. 그리디 알고리즘은 암기가 필요없이 그 주어진 상황에서 취할 수 있는 최적의 해를 찾지만 다익스트라 알고리즘은 암기를 필요로 한다.

https://velog.io/@dnwls4659/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%B5%9C%EB%8B%A8-%EA%B2%BD%EB%A1%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

```python
import sys, heapq
input = sys.stdin.readline
# 무한을 의미하는 값으로 최단 경로 테이블 초기화 목적으로 사용
INF = int(1e9)

# N : 노드 개수, M : 간선의 정보 입력
N, M = map(int, input().split())
# start : 출발 노드
start = int(input())
# 그래프의 연결 정보 저장
graph = [[] for _ in range(N+1)]
# 최단 경로 테이블
distance = [INF] * (N+1)

# 모든 간선 정보 입력받기
for _ in range(M):
    a, b, c = map(int, input().split())
    # a : 출발지
    # b : 목적지
    # c : 비용
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    # 자기 자신으로 가는 경우(거리, 노드 번호)
    heapq.heappush(q, (0, start))
    # 최단 경로 테이블 역시 같이 0으로 초기화
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        # dist보다 작은 값이라면 건드릴 이유가 없음
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 인접 노드들을 모두 확인
        # i : 출발지 번호
        # i[0] : 도착지 번호
        # i[1] : 출발지-도착지 간의 소요되는 비용
        for i in graph[now]:
            cost = dist + i[1]
            # 경유해서 갈 때 비용이 최소가 나오면 갱신
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)
for i in range(1, N+1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])
```

다익스트라의 시간복잡도를 빅오 표기법으로 나타내면 `O(E log V)`로 이 때, E는 Edge로 간선, V는 Vertex로 노드가 된다.

---

## 플로이드 워셜 알고리즘(Floyd-Warshall Algorithm)

다익스트라 알고리즘이 `한 지점에서 다른 특정 지점까지의 최단 경로를 구해야 하는 경우`에 사용되는 최단 경로 알고리즘이라면 플로이드 워셜 알고리즘은 `모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우`에 사용할 수 있는 최단 경로 알고리즘이다.

다익스트라 알고리즘은 그리디 알고리즘으로 분류가 되고 플로이드 워셜 알고리즘은 다이나믹 프로그래밍 알고리즘으로 분류가 된다.

플로이드 워셜의 핵심은 아래 두 가지를 비교해 최솟값으로 갱신을 해준다는 것이다.

```bash
[1]. A → B로 다이렉트로 가는 방법

[2]. A → K로 이동 후 K → B로 경유하여 가는 방법
```

```python
import sys
input = sys.stdin.readline
INF = 1e9

N = int(input())    # 노드 개수
M = int(input())    # 간선 개수
graph = [[INF] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    graph[i][i] = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, N+1):
    for b in range(1, N+1):
        if graph[a][b] == INF:
            print("INFINITY", end=" ")
        else:
            print(graph[a][b], end=" ")
    print()
```

---

### ▣ 실전 문제 : 미래 도시

미래 도시에는 1번부터 N번까지의 회사가 있는데 특정 회사끼리는 서로 도로를 통해 연결되어 있다.

방문 판매원 A는 현재 1번 회사에 위치해 있으며, X번 회사에 방문해 물건을 판매하고자 한다.

미래 도시에서 특정 회사에 도착하기 위한 방법은 회사끼리 연결되어 있는 도로를 이용하는 방법이 유일하다.

또한 연결된 2개의 회사는 양방향으로 이동할 수 있다. 공중 미래 도시에서 특정 회사와 다른 회사가 도로로 연결되어

있다면, 정확히 1만큼의 시간으로 이동할 수 있다.

또한 오늘 방문 판매원 A는 기대하던 소개팅에도 참석하고자 한다. 소개팅의 상대는 K번 회사에 존재한다.

방문 판매원 A는 X번 회사에 가서 물건을 판매하기 전에 먼저 소개팅 상대의 회사에 찾아가서 함께 커피를 마실 예정이다.

따라서 방문 판매원 A는 1번 회사에서 출발하여 K번 회사를 방문한 뒤에 X번 회사로 가는 것이 목표다.

이때 방문 판매원 A는 가능한 한 빠르게 이동하고자 한다.

방문 판매원이 회사 사이를 이동하게 되는 최소 시간을 계산하는 프로그램을 작성하시오.

### ▣ 입력 조건

[1]. 첫째 줄에 전체 회사의 개수 N과 경로의 개수 M이 공백으로 구분되어 차례대로 주어진다.(1 ≤ N, M ≤ 100)

[2]. 둘째 줄부터 M + 1번째 줄에는 연결된 두 회사의 번호가 공백으로 구분되어 주어진다.

[3]. M + 2번째 줄에는 X와 K가 공백으로 구분되어 차례대로 주어진다. (1 ≤ K ≤ 100)

### ▣ 출력 조건

[1]. 첫째 줄에 방문 판매원 A가 K번 회사를 거쳐 X번 회사로 가는 최소 이동 시간을 출력한다.

[2]. 만약 X번 회사에 도달할 수 없다면 -1을 출력한다.

### ▣ 입력 예시1

5 7

1 2

1 3

1 4

2 4

3 4

3 5

4 5

4 5

### ▣ 출력 예시1

3

### ▣ 입력 예시2

4 2

1 3

2 4

3 4

### ▣ 출력 예시2

-1

```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
INF = 1e9
graph = [[INF] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
    # 자기 자신으로 가는 경우는 0
    graph[i][i] = 0

for _ in range(M):
    a, b = map(int, input().split())
    # 양방향
    graph[a][b] = 1
    graph[b][a] = 1
X, K = map(int, input().split())

for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 구하고자 하는 것 : 1번에서 출발 후 K번을 경유하여 X번에 도달하는 최단 거리
if graph[X][K] == INF:
    print(-1)
else:
    distance = graph[1][K] + graph[K][X]
    print(distance)
```

---

### ▣ 실전 문제 : 전보★

어떤 나라에는 N개의 도시가 있다. 그리고 각 도시는 보내고자 하는 메시지가 있는 경우, 다른 도시로 전보를 보내서 다른 도시로 해당 메시지를 전송할 수 있다. 

하지만 X라는 도시에서 Y라는 도시로 전보를 보내고자 한다면, 도시 X에서 Y로 향하는 통로가 설치되어 있어야 한다. 

예를 들어 X에서 Y로 향하는 통로는 있지만, Y에서 X로 향하는 통로가 없다면 Y는 X로 메시지를 보낼 수 없다. 

또한 통로를 거쳐 메시지를 보낼 때는 일정 시간이 소요된다.

어느 날 C라는 도시에서 위급 상황이 발생했다. 그래서 최대한 많은 도시로 메시지를 보내고자 한다.

메시지는 도시 C에서 출발하여 각 도시 사이에 설치된 통로를 거쳐, 최대한 많이 퍼져나갈 것이다.

각 도시의 번호와 통로가 설치되어 있는 정보가 주어졌을 때, 도시 C에서 보낸 메시지를 받게 되는 도시의 개수는 총 몇 개이며 도시들이 모두 메시지를 받는 데까지 걸리는 시간은 얼마인지 계산하는 프로그램을 작성하시오.

### ▣ 입력 조건

[1]. 첫째 줄에 도시의 개수 N, 통로의 개수 M, 메시지를 보내고자 하는 도시 C가 주어진다.
(1 ≤ N ≤ 30,000, 1 ≤ M ≤ 200,000, 1 ≤ C ≤ N)

[2]. 둘째 줄부터 M + 1번째 줄에 걸쳐서 통로에 대한 정보 X, Y, Z가 주어진다. 이는 특정 도시 X에서 다른 특정 도시 Y로 이어지는 통로가 있으며, 메시지가 전달되는 시간이 Z라는 의미다.
(1 ≤ X, Y ≤ N, 1 ≤ Z ≤ 1,000)

### ▣ 출력 조건

첫째 줄에 도시 C에서 보내 메시지를 받는 도시의 총 개수와 총 걸리는 시간을 공백으로 구분하여 출력한다.

### ▣ 입력 예시

3 2 1

1 2 4

1 3 2

### ▣ 출력 예시

2 4

```python
import sys, heapq
input = sys.stdin.readline
INF = 1e9

N, M, C = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [INF] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

distance = dijkstra(C)

count = 0
time = 0 
for i in range(1, N+1):
    if distance[i] != INF:  
        count += 1
        time = max(time, distance[i])
print(count-1, time)
```
