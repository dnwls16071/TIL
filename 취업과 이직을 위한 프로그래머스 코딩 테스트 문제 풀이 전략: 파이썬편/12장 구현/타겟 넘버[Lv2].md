### 📌문제 설명

n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

### 📌제한 조건

주어지는 숫자의 개수는 2개 이상 20개 이하입니다.

각 숫자는 1 이상 50 이하인 자연수입니다.

타겟 넘버는 1 이상 1000 이하인 자연수입니다.

### 📌입출력 예

|numbers|target|return|
|:------:|:------:|:------:|
|[1, 1, 1, 1, 1]|3|5|
|[4, 1, 2, 1]|4|2|

### 📌소스 코드[DFS]

```python
def solution(numbers, target):
    ct = 0
    def DFS(idx, result):
        nonlocal ct
        if idx == len(numbers):
            if result == target:
                ct += 1
            else:
                return
        else:
            DFS(idx+1, result+numbers[idx])
            DFS(idx+1, result-numbers[idx])
    DFS(0, 0)
    return ct
```

### 📌소스 코드[BFS]

```python
from collections import deque

def solution(numbers, target):
    n = len(numbers)
    q = deque()
    q.append([numbers[0], 0])
    q.append([-1*numbers[0], 0])
    answer = 0
    while q:
        v, idx = q.popleft()
        idx += 1
        if idx < n:
            q.append([v + numbers[idx], idx])
            q.append([v - numbers[idx], idx])
        else:
            if v == target:
                answer += 1
    return answer
```
