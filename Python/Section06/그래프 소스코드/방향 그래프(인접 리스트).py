import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adjList = [[] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    adjList[s].append(e)

for i in range(N+1):
    print(adjList[i])

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
# []
# [2, 3]
# [1, 3, 5]
# [4]
# [2, 5]
# []
# [4]
