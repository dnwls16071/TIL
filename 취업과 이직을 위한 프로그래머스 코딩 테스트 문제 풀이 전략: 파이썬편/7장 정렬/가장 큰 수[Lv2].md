### 📌문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

### 📌제한 조건

numbers의 길이는 1 이상 100,000 이하입니다.

numbers의 원소는 0 이상 1,000 이하입니다.

정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

### 📌입출력 예

|numbers|return|
|:-----:|:-----:|
|[6, 10, 2]|"6210"|
|[3, 30, 34, 5, 9]|"9534330"|

### 📌소스 코드[1] - 배열에 담긴 원소가 모두 0인 경우를 처리해준 코드

```python
def solution(numbers):
    numbers = list(map(str, numbers))
    numbers  = sorted(numbers, key=lambda x : x*3, reverse=True)
    
    answer = "".join(map(str, numbers))
    if int(answer) == 0:
        return "0"
    else:
        return "".join(map(str, numbers))
```

### 📌소스 코드[2] - functools를 활용한 코드

```python
import functools

def xy_compare(n1, n2):
    res1 = n1 + n2
    res2 = n2 + n1
    return (int(res1) > int(res2)) - (int(res1) < int(res2))

def solution(numbers):
    numbers = list(map(str, numbers))
    numbers = sorted(numbers, key=functools.cmp_to_key(xy_compare), reverse=True)
    answer = str(int(''.join(numbers)))
    return answer
```

