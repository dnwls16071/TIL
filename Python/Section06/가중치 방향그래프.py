import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adjList = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(M):
    s, e, dis = map(int, input().split())
    adjList[s-1][e-1] = dis

for i in range(N+1):
    for j in range(N+1):
        print(adjList[i][j], end=" ")
    print()

# 입력
# 6 9
# 1 2 7
# 1 3 4
# 2 1 2
# 2 3 5
# 2 5 5
# 3 4 5
# 4 2 2
# 4 5 5
# 6 4 5

# 출력
# 0 7 4 0 0 0 0 
# 2 0 5 0 5 0 0
# 0 0 0 5 0 0 0
# 0 2 0 0 5 0 0
# 0 0 0 0 0 0 0
# 0 0 0 5 0 0 0
# 0 0 0 0 0 0 0
