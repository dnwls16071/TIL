# 이진 탐색(Binary Search)

**순차 탐색**(**Sequential Search**)이란 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법이다.

보통 정렬되지 않은 리스트에서 데이터를 찾아야 할 때 사용한다. 리스트 내에 아무리 데이터가 많아도 시간이 충분하다면 항상 원하는 데이터를 찾을 수 있다.

데이터의 개수가 N개일 때, 최대 N번의 비교 연산이 필요하므로 순차 탐색의 최악의 경우 시간복잡도는 빅오 표기법으로 `O(N)`이다.

---

**이진 탐색**(**Binary Search**)이란 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다. 데이터가 무작위일 때는 사용할 수 없지만, 이미 정렬되어 있다면 매우 빠르게 데이터를 찾을 수 있다는 특징이 있다.

이진 탐색은 탐색 범위를 절반으로 좁혀가며 데이터를 탐색한다는 특징이 있다.

이진 탐색은 위치를 나타내는 변수 3개를 사용하는데 탐색하고자 하는 범위의 시작점, 끝점 그리고 중간점이다.

한 번 확인할 때마다 확인하는 원소의 개수가 절반씩 줄어든다는 점에서 시간 복잡도를 빅오 표기법으로 나타내면 `O(log N)`이다.

```python
import sys
input = sys.stdin.readline

N, target = list(map(int, input().split()))
array = list(map(int, input().split()))

def binarySearch(data, start, end):
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return mid
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

result = binarySearch(array, 0, len(array)-1)
if binarySearch == None:
    print("원소를 찾을 수 없습니다.")
else:
    print(result+1)
```

---

이진 탐색 문제는 입력 데이터가 많거나 탐색 범위가 매우 넓은 편이다. 

입력 데이터가 많은 경우 sys 라이브러리의 readline() 함수를 이용하면 시간초과를 피할 수 있다.

sys라이브러리를 사용할 때는 한 줄을 입력받고 나서 rstrip() 함수를 꼭 호출해야 한다. 소스코드에 readline()으로 입력하면 입력 후 엔터가 줄바꿈 기호로 입력되는데 이 공백문자를 제거하려면 rstrip()을 사용해야 한다.

---

### ▣ 실전 문제 : 부품 찾기

동빈이네 전자 매장에는 부품이 N개가 있다. 각 부품은 정수 형태의 고유한 번호가 있다.

어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다.

동빈이는 때를 놓치지 않고 손님이 문의한 부품 M개 종류를 모두 확인해서 견적서를 작성해야 한다.

이 때, 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성하세요.

예를 들어, 가게의 부품이 총 5개일 때 부품 번호가 다음과 같다고 하자.

```bash
N = 5
[8, 3, 7, 9, 2]
```

손님은 총 3개의 부품이 있는지 확인 요청했는데 부품 번호는 다음과 같다.

```bash
M = 3
[5, 7, 9]
```

이 때, 손님이 요청한 부품 번호의 순서대로 부품을 확인해 그 부품이 있으면 yes를, 없으면 no를 출력한다. 구분은 공백으로 한다.

### ▣ 입력 조건

[1]. 첫째 줄에 정수 N이 주어진다.(1 ≤ N ≤ 1,000,000)

[2]. 둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다. 이 떄, 정수는 1보다 크고 1,000,000이하이다.

[3]. 셋째 줄에는 정수 M이 주어진다.(1 ≤ M ≤ 100,000)

[4]. 넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다. 이 때, 정수는 1보다 크고 1,000,000이하이다.

### ▣ 출력 조건

첫째 줄에 공백으로 구분하여 각 부품이 존재하면 yes를, 없으면 no를 출력한다.

### ▣ 입력 예시

5

8 3 7 9 2

3

5 7 9

### ▣ 출력 예시

no yes yes

```python
import sys
input = sys.stdin.readline

N = int(input())
arr1 = list(map(int, input().split()))
M = int(input())
arr2 = list(map(int, input().split()))

arr1.sort() # 오름차순 정렬

def binarySearch(data, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if data[mid] == target:
            return mid
        elif data[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

for i in arr2:
    result = binarySearch(arr1, i, 0, len(arr1)-1)
    if result == None:
        print("no", end=" ")
    else:
        print("yes", end=" ")
```

---

### ▣ 실전 문제 : 떡볶이 떡 만들기

오늘 동빈이는 여행 가신 부모님을 대신해서 떡집 일을 하기로 했다. 오늘은 떡볶이 떡을 만드는 날이다.

동빈이네 떡볶이 떡은 재밌게도 떡볶이 떡의 길이가 일정하지 않다. 대신에 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 맞춰서 잘라준다.

절단기에 높이 H를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H 위의 부분이 잘릴 것이고 낮은 떡은 잘리지 않는다.

예를 들어, 높이가 19, 14, 10, 17cm인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡의 높이는 15, 14, 10, 15cm가 될 것이다.

잘린 떡의 길이는 차례대로 4, 0, 0, 2cm이다. 손님은 6cm만큼의 길이를 가져간다.

손님이 왔을 때, 요청한 총 길이가 M일 때, 적어도 M만큼의 떡을 얻기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하라.


### ▣ 입력 조건

[1]. 첫째 줄에 떡의 갯수 N과 요청한 떡의 길이 M이 주어진다.(1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)

[2]. 둘째 줄에는 떡의 개별 높이가 주어진다. 떡 높이의 총합은 항상 M이상이므로 손님은 필요한 양만큼의 떡을 사갈 수 있다. 

[3]. 높이는 10억보다 작거나 같은 양의 정수 또는 0이다.

### ▣ 출력 조건

적어도 M만큼의 떡을 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.

### ▣ 입력 예시

4 6

19 15 10 17

### ▣ 출력 예시

15

```python
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
height = list(map(int, input().split()))

def binarySearch(data, start, end):
    while start <= end:
        result = 0  # 썰린 떡의 누적 길이
        mid = (start + end) // 2
        for x in data:
            if x >= mid:
                result += (x - mid)
        # 썰린 떡의 총 길이가 M이면 멈춤
        if result == M:
            print(mid)
            break
        # 썰린 떡의 총 길이가 M보다 크면? ▶ 절단기의 높이를 높여야 함
        elif result > M:
            start = mid + 1
        # 썰린 떡의 총 길이가 M보다 작으면? ▶ 절단기의 높이를 낮춰야 함
        else:
            end = mid - 1

binarySearch(height, 0, max(height))
```
