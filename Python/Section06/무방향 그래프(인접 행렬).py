import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adjList = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    # s와 e사이에 간선의 존재 여부를 나타냄(1이면 연결O, 0이면 연결X)
    adjList[s][e] = 1
    adjList[e][s] = 1

for i in range(N+1):
    for j in range(N+1):
        print(adjList[i][j], end=" ")
    print()
