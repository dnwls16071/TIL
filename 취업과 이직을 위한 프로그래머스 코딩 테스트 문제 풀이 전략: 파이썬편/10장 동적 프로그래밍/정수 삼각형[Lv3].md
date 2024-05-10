### 📌문제 설명

<img width="184" alt="296a0863-a418-431d-9e8c-e57f7a9722ac" src="https://github.com/dnwls16071/TIL/assets/106802375/ce51e2ad-6635-4bcc-8e60-dc1b6f01afdc">

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

### 📌제한 조건

삼각형의 높이는 1 이상 500 이하입니다.

삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

### 📌입출력 예

|triangle|return|
|:-----:|:-----:|
|[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]|30|

### 📌소스 코드

```python
def solution(triangle):
    height = len(triangle)
    dp = [[0] * height for _ in range(height)]
    dp[0][0] = triangle[0][0]
    
    """
    삼각형의 모서리 부분의 합을 먼저 구함
    """
    for i in range(1, height):
        dp[i][0] = dp[i-1][0] + triangle[i][0]
        dp[i][i] = dp[i-1][i-1] + triangle[i][-1]
        
    """
    삼각형 모서리를 제외한 안쪽 부분의 합을 구함
    """
    for i in range(2, height):
        for j in range(1, i):
            dp[i][j] = max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j])    
    answer = max(dp[-1])
    return answer
```
