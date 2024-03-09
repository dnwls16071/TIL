# 바둑이 승차(DFS)

철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다. 

철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다. N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.

## ▣ 입력설명

첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.

둘째 줄부터 N마리 바둑이의 무게가 주어진다.

## ▣ 출력설명

첫 번째 줄에 가장 무거운 무게를 출력한다.

## ▣ 입력예제 1

259 5

81

58

42

33

61

## ▣ 출력예제 1

242

▣ 첫 번째 풀이(Time Limit Exceeded)

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

C, N = map(int, input().split())
checklist = [0] * (N+1)
array = []
MAX = -2147000000
for _ in range(N):
    num = int(input())
    array.append(num)

def DFS(idx, tot):
    global C, MAX
    if tot > C:
        return
    if idx == N:
        if tot > MAX and tot <= C:
            MAX = max(MAX, tot)
    else:
        checklist[idx] = 1
        DFS(idx+1, tot+array[idx])
        checklist[idx] = 0
        DFS(idx+1, tot)
    return MAX

DFS(0, 0)
print(MAX)
```

- 첫 번째 풀이의 경우 Test Case #4, #5에서 시간초과가 발생했다.

- 커뮤니티에서 시간 초과가 발생하는 원인에 대한 부분을 찾을 수 있었는데 그것은 바로 불필요한 탐색이 이루어진다는 글이었다.

- 처음에 배열에 들어있는 바둑이들의 무게 총합이 제한 무게인 C를 넘어서지 않는다면 그 즉시 탐색을 멈출 수 있게끔 하는 것이 시간을 줄일 수 있는 부분이다.

▣ 두 번째 풀이

```python
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

C, N = map(int, input().split())
checklist = [0] * (N+1)
array = []
MAX = -2147000000
for _ in range(N):
    num = int(input())
    array.append(num)

def DFS(idx, tot):
    global C, MAX
    if sum(array) < C:
        MAX = sum(array)
        return
    if tot > C:
        return
    if idx == N:
        if tot > MAX and tot <= C:
            MAX = max(MAX, tot)
    else:
        checklist[idx] = 1
        DFS(idx+1, tot+array[idx])
        checklist[idx] = 0
        DFS(idx+1, tot)
    return MAX

DFS(0, 0)
print(MAX)
```

▣ 문제풀이 시간 : 25m

▣ 체감 난이도 : ★★
