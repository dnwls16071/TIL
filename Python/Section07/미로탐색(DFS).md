# 미로탐색

7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요. 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다. 

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/00a2564c-f3a2-4573-92c1-9a912962f103)

위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다

## ▣ 입력설명

7*7 격자판의 정보가 주어집니다.

## ▣ 출력설명

첫 번째 줄에 경로의 가지수를 출력한다.

## ▣ 입력예제 1

0 0 0 0 0 0 0

0 1 1 1 1 1 0

0 0 0 1 0 0 0

1 1 0 1 0 1 1

1 1 0 0 0 0 1

1 1 0 1 1 0 0

1 0 0 0 0 0 0

## ▣ 출력예제 1

8

▣ 풀이

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

graph = [list(map(int, input().split())) for _ in range(7)]
visited = [[False] * 7 for _ in range(7)]
cnt = 0

def DFS(y, x):
    global cnt
    if y == 6 and x == 6:
        cnt += 1
        return
    else:
        dy = [1, 0, -1, 0]
        dx = [0, 1, 0, -1]
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < 7 and 0 <= nx < 7 and not visited[ny][nx]:
                if graph[ny][nx] == 0:
                    visited[ny][nx] = True
                    DFS(ny, nx)
                    visited[ny][nx] = False

graph[0][0] = 1
DFS(0, 0)
print(cnt)
```

▣ 문제풀이 시간 : 26m

▣ 체감 난이도 : ★★
