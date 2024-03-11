import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adjMatrix = [[0 for _ in range(N+1)] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    adjMatrix[s][e] = 1

for i in range(N+1):
    for j in range(N+1):
        print(adjMatrix[i][j], end=" ")
    print()

# 입력
# 6 9
# 1 2
# 1 3
# 2 1
# 2 3
# 2 5
# 3 4
# 4 2
# 4 5
# 6 4

# 출력
# 0 0 0 0 0 0 0 
# 0 0 1 1 0 0 0
# 0 1 0 1 0 1 0
# 0 0 0 0 1 0 0
# 0 0 1 0 0 1 0
# 0 0 0 0 0 0 0
# 0 0 0 0 1 0 0
