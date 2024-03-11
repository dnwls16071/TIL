# 경로 탐색(그래프 DFS)

방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요. 

아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는

![캡처](https://github.com/dnwls16071/TIL/assets/106802375/00f4e80a-72be-43b0-8f21-b4891ef762d8)

총 6 가지입니다.

그래프에서 경로란 방문한 노드는 중복해서 방문하지 않습니다.

## ▣ 입력설명

첫째 줄에는 정점의 수 N(2<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

## ▣ 출력설명

총 가지수를 출력한다.

## ▣ 입력예제 1

5 9

1 2

1 3

1 4

2 1

2 3

2 5

3 4

4 2

4 5

## ▣ 출력예제 1

6


▣ 풀이

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
cnt = 0
checklist = [0] * (N+1)
checklist[1] = 1
for _ in range(M):
    s, e = map(int, input().split())
    graph[s][e] = 1

def DFS(start):
    global cnt
    if start == N:
        cnt += 1
    else:
        for i in range(1, N+1):
            if graph[start][i] == 1 and checklist[i] == 0:
                checklist[i] = 1
                DFS(i)
                checklist[i] = 0

DFS(1)
print(cnt)
```

- 방문했던 노드에 대한 재방문을 허용하지 않으므로 방문여부를 따지는 배열을 만든다.

- 가중치를 필요로 하지 않고 노드와 노드 간에 연결 여부를 확인하는 부분에 초점을 맞추므로 인접 행렬을 이용한다.

▣ 문제풀이 시간 : 15m

▣ 체감 난이도 : ★★
