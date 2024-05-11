### 📌문제 설명

n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

### 📌제한 조건

선수의 수는 1명 이상 100명 이하입니다.

경기 결과는 1개 이상 4,500개 이하입니다.

results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.

모든 경기 결과에는 모순이 없습니다.

### 📌입출력 예

|n|prices|return|
|:------:|:------:|:------:|
|5|[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]|2|


### 📌소스 코드

```python
def solution(n, results):
    answer = 0
    graph = [[False] * (n + 1) for _ in range(n + 1)]
    for result in results:
        # a가 b를 이긴다.
        # 4번이 3번을 이기고 3번이 2번을 이긴다면 4번이 2번을 이긴다는 간접적 추론이 가능함
        a, b = result
        graph[a][b] = True
    
    # 플로이드-워셜 알고리즘(3중 반복문)
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = True

    # 명확하게 순위를 알 수 있는 경우 : 해당 번호의 가로줄/세로줄에 있는 True의 개수가 자기 자신과 싸우는 경우를 제외한 n-1이라면 정확하게 순위를 매길 수 있음
    for a in range(1, n + 1):
        cnt = 0
        for b in range(1, n + 1):
            if a == b:
                continue
                
            if graph[a][b] or graph[b][a]:
                cnt += 1
        if cnt == n - 1:
            answer += 1
    return answer
```
