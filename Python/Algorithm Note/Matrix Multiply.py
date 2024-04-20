import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr1 = [list(map(int, input().split())) for _ in range(N)]

M, K = map(int, input().split())
arr2 = [list(map(int, input().split())) for _ in range(M)]

result = [[0] * K for _ in range(N)]
for i in range(N):
    for j in range(K):
        for k in range(M):
            result[i][j] += arr1[i][k] * arr2[k][j]

for i in result:
    print(*i)

# 첫 번째 배열의 열 길이 : N, 첫 번째 배열의 행 길이 : M
# 두 번째 배열의 열 길이 : M, 두 번째 배열의 행 길이 : K
# 행렬의 곱셈 연산이 가능하려면 N X M 배열과 M X K 배열 두 개에서 첫 번째 배열의 행 길이와 두 번째 배열의 열 길이가 같아야 한다.
