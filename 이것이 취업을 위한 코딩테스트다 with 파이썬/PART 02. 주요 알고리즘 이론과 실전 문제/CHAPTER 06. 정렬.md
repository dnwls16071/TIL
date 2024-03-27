# 정렬(Sorting)

정렬(Sorting)이란, 데이터를 특정한 기준에 따라서 순서대로 나열하는 것을 말한다. 

프로그램에서 데이터를 가공할 때 오름차순이나 내림차순 등 대부분 어떤 식으로든 정렬해서 사용하는 경우가 많기에 정렬 알고리즘은 프로그램을 작성할 때 가장 많이 사용되는 알고리즘 중 하나이다.

정렬 알고리즘으로 데이터를 정렬하면 추후에 학습할 이진 탐색이 가능해진다.

---

## 선택 정렬(Selection Sort)

컴퓨터가 데이터를 정렬할 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복하면 어떨까?

이 방법은 가장 원시적인 방법으로 **매번 가장 작은 것을 선택한다**는 의미에서 선택 정렬 알고리즘이라고 한다.

```python
data = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(data)):
    min_index = i
    for j in range(i+1, len(data)):
        if data[min_index] > data[j]:
            min_index = j
    data[i], data[min_index] = data[min_index], data[i]
print(data)
```

가장 작은 값을 골라 맨 앞에 있는 원소와 바꾸고 그 다음으로 가장 작은 값을 골라 그 다음에 있는 원소와 바꾸고 이와 같은 작업을 계속 반복한다.

선택 정렬의 시간복잡도를 빅오 표기법으로 나타내면 `O(N^2)`이라고 할 수 있다.

선택 정렬은 기본 라이브러리를 포함해 뒤에서 다룰 알고리즘과 비교했을 때 매우 비효율적이다.

다만, 특정 리스트에서는 가장 작은 데이터를 찾는 일이 코딩테스트에서 잦으므로 선택 정렬 소스코드 형태에 익숙해질 필요가 있다.

---

## 삽입 정렬(Insertion Sort)

**데이터를 하나씩 확인하며 적절한 위치에 삽입하는 방식**을 삽입 정렬이라고 한다.

```python
data = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(data)):
    for j in range(i, 0, -1):
        if data[j] < data[j-1]:
            data[j], data[j-1] = data[j-1], data[j]
        else:
            break
print(data)
```

삽입 정렬의 시간복잡도를 빅오 표기법으로 나타내면 선택 정렬과 같이 `O(N^2)`이다. 

선택 정렬과 시간복잡도가 같지만 하나 주의할 점이 있다면 삽입 정렬은 최선의 경우 즉, 데이터가 거의 정렬이 수행된 상태에서는 `O(N)`의 시간복잡도를 가진다.

---

## 퀵 정렬(Quick Sort)

**기준 데이터(=피벗)를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 정렬 방법**이다.

피벗보다 큰 데이터를 왼쪽에서부터 탐색, 피벗보다 작은 데이터를 오른쪽에서부터 탐색하여 두 데이터의 위치를 바꾼다.

```python
data = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quickSort(data, start, end):
    # 역전된 경우 ▶ 원소가 1개만 남았을 떄
    if start >= end:
        return
    # 피벗은 첫 번째 원소
    pivot = start
    left = start + 1
    right = end
    while left <= right:
        # 왼쪽에서부터 탐색해서 피벗보다 큰 데이터를 찾는다.
        while left <= end and data[left] <= data[pivot]:
            left += 1
        # 오른쪽에서부터 탐색해서 피벗보다 작은 데이터를 찾는다.
        while right > start and data[right] >= data[pivot]:
            right -= 1
        # 엇갈리면 데이터 스와프(작은 데이터와 피벗 교체)
        if left > right:
            data[right], data[pivot] = data[pivot], data[right]
        # 안 엇갈리면 데이터 스와프(작은 데이터와 큰 데이터 교체)
        else:
            data[left], data[right] = data[right], data[left]
    quickSort(data, start, right-1)
    quickSort(data, right+1, end)

quickSort(data, 0, len(data)-1)
print(data)
```

퀵 정렬의 평균 시간복잡도는 빅오 표기법으로 나타내면 `O(N log N)`이다.

---

### ▣ 실전 문제 : 위에서 아래로

하나의 수열에는 다양한 수가 존재한다. 이러한 수는 크기에 상관없이 나열되어 있다.

이 수를 큰 수부터 작은 수로 정렬해야 한다. 수열을 내림차순으로 정렬하는 프로그램을 작성하라.

### ▣ 입력 조건

[1]. 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다.(1 ≤ N ≤ 500)

[2]. 둘째 줄부터 N + 1번째 줄까지 N개의 수가 입력된다. 수의 범위는 1이상 100,000이하의 자연수이다.

### ▣ 출력 조건

입력으로 주어진 수열이 내림차순으로 정렬된 결과를 공백으로 구분하여 출력한다.

동일한 수의 순서를 자유롭게 출력해도 괜찮다.

### ▣ 입력 예시

3

15

27

12

### ▣ 출력 예시

27 15 12

```python
import sys
input = sys.stdin.readline

N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort(reverse=True)
print(*arr)
```

---

### ▣ 실전 문제 : 성적이 낮은 순서로 학생 출력하기

N명의 학생 정보가 있다. 학생 정보는 학생의 이름과 학생의 성적으로 구분된다.

각 학생의 이름과 성적 정보가 주어졌을 때, 성적이 낮은 순서대로 학생의 이름을 출력하는 프로그램을 작성하시오.

### ▣ 입력 조건

[1]. 첫째 줄에 학생의 수 N이 입력된다.(1 ≤ N ≤ 100,000)

[2]. 두 번째 줄부터 N+1번째 줄에는 학생의 이름을 나타내는 문자열 A와 학생의 성적을 나타내는 정수 B가 공백으로 구분되어 입력된다.

[3]. 문자열 A의 길이와 학생의 성적은 100 이하의 자연수이다.

### ▣ 출력 조건

모든 학생의 이름을 성적이 낮은 순서대로 출력한다. 성적이 동일한 학생들의 순서는 자유롭게 출력해도 괜찮다.

### ▣ 입력 예시

2

홍길동 95

이순신 77

### ▣ 출력 예시

아순신 홍길동

```python
import sys
input = sys.stdin.readline

N = int(input())
arr = []
for _ in range(N):
    name, score = map(str, input().split())
    score = int(score)
    arr.append((name, score))
arr = sorted(arr, key=lambda x : x[1])
for i in arr:
    print(i[0], end=" ")
```

---

### ▣ 실전 문제 :  두 배열의 원소 교체

동빈이는 두 개의 배열 A와 B를 가지고 있다. 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.

동빈이는 최대 K번의 바꿔치기 연산을 수행할 수 있는데, 바꿔치기 연산이란 배열 A에 있는 원소 하나와 배열 B에 있는 원소 하나를 골라서 두 원소를 서로 바꾸는 것을 말한다.

동빈이의 최종 목표는 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이며, 여러분은 동빈이를 도와야 한다.

N, K 그리고 배열 A와 B의 정보가 주어졌을 때, 최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력하는 프로그램을 작성하시오.

### ▣ 입력 조건

[1]. 첫 번째 줄에 N, K가 공백으로 구분되어 입력된다.(1 ≤ N ≤ 100,000, 0 ≤ K ≤ N) 

[2]. 두 번째 줄에 배열 A의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 작은 자연수이다.

[3]. 세 번째 줄에 배열 B의 원소들이 공백으로 구분되어 입력된다. 모든 원소는 10,000,000보다 작은 자연수이다.

### ▣ 출력 조건

최대 K번의 바꿔치기 연산을 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최댓값을 출력한다.

### ▣ 입력 예시

5 3

1 2 5 4 3

5 5 6 6 5

### ▣ 출력 예시

26

```python
import sys
input = sys.stdin.readline
from collections import deque

N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

for i in range(K):
    if A[i] <= B[i]:
        A[i], B[i] = B[i], A[i]
    else:
        break
print(sum(A))
```

- 배열 A의 작은 원소와 배열 B의 큰 원소를 바꿔치기 한다.
