# 부분집합 구하기(DFS)

자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

## ▣ 입력설명

첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

## ▣ 출력설명

첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.

단 공집합은 출력하지 않습니다.

## ▣ 입력예제 1

3

## ▣ 출력예제 1

1 2 3

1 2

1 3

1

2 3

2

3

▣ 풀이

```python
import sys
input = sys.stdin.readline

N = int(input())
checklist = [0] * (N+1)

def DFS(x):
    if x == N+1:
        for i in range(1, N+1):
            if checklist[i] == 1:
                print(i, end=" ")
        print()
        return
    else:
        checklist[x] = 1
        DFS(x+1)
        checklist[x] = 0
        DFS(x+1)

DFS(1)
```

### ❗DFS(Depth-First Search: 깊이 우선 탐색)

(1). 시작 노드를 스택에 push

(2). 맨 앞의 값을 꺼냄

(3). 꺼낸 값으로 문제에서 요구하는 연산을 수행

(4). 인접한 노드를 스택에 저장

(5). 스택이 빌 때까지 (2)~(5)번의 과정을 반복

▣ 문제풀이 시간 : 15m

▣ 체감 난이도 : ★★
