### 📌문제 설명

도둑이 어느 마을을 털 계획을 하고 있습니다. 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.

![a228c73d-1cbe-4d59-bb5d-833fd18d3382](https://github.com/dnwls16071/TIL/assets/106802375/bada0104-7f89-4be9-bdc1-8b21e2a7f09c)

각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.

각 집에 있는 돈이 담긴 배열 money가 주어질 때, 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.

### 📌제한 조건

이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.

money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.

### 📌입출력 예

|n|return|
|:-----:|:-----:|
|3|2|
|5|5|

### 📌소스 코드

```python
"""
간과했던 부분(Ex. 집 5개) - 원형의 형태
맨 처음부터 턴다면 맨 처음과 맨 마지막이 인접하는 문제가 발생
"""
def solution(money):
    """
    [1]. 첫 번째 집을 털고 세 번째 집을 턴다.
    [2]. 두 번째 집을 털고 그 다음 집은 털지 않는다.
    """
    dp1 = [0] * len(money) 
    dp2 = [0] * len(money)
    # 첫 번째 집 털고 세 번째 집을 턴다.
    dp1[0] = dp1[1] = money[0]
    for i in range(2, len(money)-1):
        dp1[i] = max(dp1[i-2] + money[i], dp1[i-1])
    
    # 두 번째 집을 턴다.
    dp2[1] = money[1]
    for i in range(2, len(money)):
        dp2[i] = max(dp2[i-1], dp2[i-2] + money[i]) 
    return max(max(dp1), max(dp2))
```
