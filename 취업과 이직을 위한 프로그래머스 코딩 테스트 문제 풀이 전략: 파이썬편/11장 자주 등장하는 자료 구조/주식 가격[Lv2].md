### 📌문제 설명

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

### 📌제한 조건

prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.

prices의 길이는 2 이상 100,000 이하입니다.

### 📌입출력 예

|prices|return|
|:------:|:------:|
|[1, 2, 3, 2, 3]|[4, 3, 1, 1, 0]|

### 📌소스 코드

```python
def solution(prices):
    stack = [0] # 시점을 저장하는 수단
    answer = [i for i in range(len(prices)-1, -1, -1)]
    for i in range(1, len(prices)):
        while stack and prices[stack[-1]] > prices[i]:
            seq = stack.pop()
            answer[seq] = i - seq
        stack.append(i)
    return answer
```
