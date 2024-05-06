### 📌문제 설명

정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

### 📌제한 조건

numbers의 길이는 2 이상 100 이하입니다.

numbers의 모든 수는 0 이상 100 이하입니다.

### 📌입출력 예

|numbers|result|
|:-----:|:-----:|
|[2,1,3,4,1|[2,3,4,5,6,7]|
|[5,0,2,7]|[2,5,7,9,12]|

### 📌소스 코드

```python
def solution(numbers):
    visited = [False] * len(numbers)
    result = set()
    def DFS(numbers, lst):
        if len(lst) == 2:
            result.add(sum(lst))
            return
        for i in range(len(numbers)):
            if not visited[i]:
                visited[i] = True
                lst.append(numbers[i])
                DFS(numbers, lst)
                visited[i] = False
                lst.pop()
        return result
    result = DFS(numbers, [])
    result = list(result)
    result.sort()
    return result
```
