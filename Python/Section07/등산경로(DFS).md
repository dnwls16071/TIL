# 등산경로(DFS)

등산을 매우 좋아하는 철수는 마을에 있는 뒷산에 등산경로를 만들 계획을 세우고 있습니다.

마을 뒷산의 형태를 나타낸 지도는 N*N 구역으로 나뉘어져 있으며, 각 구역에는 높이가 함께 나타나 있습니다.

N=5이면 아래와 같이 표현됩니다.

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/7ac7c1c1-2e96-49b8-9d85-4fede9ef7a5d)

어떤 구역에서 다른 구역으로 등산을 할 때는 그 구역의 위, 아래, 왼쪽, 오른쪽 중 더 높은 구역으로만 이동할 수 있도록 등산로를 설계하려고 합니다. 

등산로의 출발지는 전체 영역에서 가장 낮은 곳이고, 목적지는 가장 높은 곳입니다. 출발지와 목적지는 유일합니다.

지도가 주어지면 출발지에서 도착지로 갈 수 있는 등산 경로가 몇 가지 인지 구하는 프로그램을 작성하세요.

## ▣ 입력설명

첫 번째 줄에 N(5<=N<=13)주어지고, N*N의 지도정보가 N줄에 걸쳐 주어진다.

## ▣ 출력설명

등산경로의 가지수를 출력한다.

## ▣ 입력예제 1

5

2 23 92 78 93

59 50 48 90 80

30 53 70 75 96

94 91 82 89 93

97 98 95 96 100

## ▣ 출력예제 1

5

▣ 풀이

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
cnt = 0

MIN = 2147000000
MAX = -2147000000
for i in range(N):
    for j in range(N):
        if graph[i][j] < MIN:
            MIN = min(MIN, graph[i][j])
            min_y = i; min_x = j
        if graph[i][j] > MAX:
            MAX = max(MAX, graph[i][j])
            max_y = i; max_x = j

def DFS(y, x):
    global cnt
    if y == max_y and x == max_x:
        cnt += 1
        return
    else:
        dy = [1, 0, -1, 0]
        dx = [0, 1, 0 ,-1]
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx]:
                if graph[ny][nx] > graph[y][x]:
                    visited[ny][nx] = True
                    DFS(ny, nx)
                    visited[ny][nx] = False

visited[min_y][min_x] = 1
DFS(min_y, min_x)
print(cnt)
```

- 등산로의 출발점은 2차원 배열에서 가장 작은 값, 등산로의 도착점은 2차원 배열에서 가장 큰 값

- 방문 여부 작성하여 방문했던 곳을 다시 가지 않도록 체크

▣ 문제풀이 시간 : 16m

▣ 체감 난이도 : ★
