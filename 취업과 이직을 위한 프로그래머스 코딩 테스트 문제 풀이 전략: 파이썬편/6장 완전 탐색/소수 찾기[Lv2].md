### 📌문제 설명

한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

### 📌제한 조건

numbers는 길이 1 이상 7 이하인 문자열입니다.

numbers는 0~9까지 숫자만으로 이루어져 있습니다.

"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

### 📌입출력 예

|numbers|return|
|:-----:|:-----:|
|"17"|3|
|"011"|2|

### 📌소스 코드

```python
from itertools import permutations

def check(n):
    if n == 0 or n == 1:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    cnt = 0
    lst = list(map(str, numbers))

    res = set()
    """
    11과 011은 int로 취급할 경우 같으므로 이런 경우를 중복 카운팅하는 것을 방지하기 위해 집합 자료형 사용
    """
    for i in range(1, len(lst) + 1):
        for perm in permutations(lst, i):
            num = int("".join(map(str, perm)))
            if check(num) and num not in res:
                res.add(num)
    return len(res)
```
