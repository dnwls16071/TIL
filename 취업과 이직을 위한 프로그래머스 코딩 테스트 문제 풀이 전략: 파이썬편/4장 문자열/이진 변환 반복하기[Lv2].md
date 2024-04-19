
### 📌문제 설명

0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

x의 모든 0을 제거합니다.

x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.

예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.

### 📌제한 조건

s의 길이는 1 이상 150,000 이하입니다.

s에는 '1'이 최소 하나 이상 포함되어 있습니다.

### 📌입출력 예

|s|result|
|:-----:|:-----:|
|"110010101001"|[3,8]|
|"01110"|[3,3]|
|"1111111"|[4,1]|

### 📌소스 코드

```python
def solution(s):
    val1, val2 = convert(s)
    return [val1, val2]


def convert(n):
    zero_cnt = 0
    conv_cnt = 0
    while len(n) != 1:
        result = ""
        for i in n:
            if int(i) == 0:
                zero_cnt += 1
            else:
                result += "1"
        len_res = len(result)
        answer = []
        while len_res != 0:
            answer.append(len_res % 2)
            len_res //= 2
        answer = answer[::-1]
        n = answer
        conv_cnt += 1
    return [conv_cnt, zero_cnt]
```

### 📌소스 코드[책.ver]

```python
def solution(s):
    change, zero = 0, 0
    while s != '1':
        change += 1
        num = s.count('1')
        zero += len(s) - num
        s = bin(num)[2:]
    return [change, zero]
```
