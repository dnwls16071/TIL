sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]

def merge(left, right):
    result = []
    """
    왼쪽 & 오른쪽 부분 배열이 모두 존재한다면?
    """
    while len(left) > 0 and len(right) > 0:
        """
        왼쪽이 더 작으면 왼쪽의 첫 번째 원소를 추가 후 슬라이싱 처리하여 반영
        오른쪽이 더 작으면 오른쪽의 첫 번째 원소를 추가 후 슬라이싱 처리하여 반영
        """
        if left[0] <= right[0]:
            result.append(left[0])
            left = left[1:]
        else:
            result.append(right[0])
            right = right[1:]
    """
    나머지 원소를 추가하기 위해 extend로 확장하여 반영
    """
    result.extend([*left , *right])
    return result

def mergeSort(data):
    if len(data) <= 1:
        return data
    mid = len(data) // 2
    left = mergeSort(data[:mid])
    right = mergeSort(data[mid:])
    return merge(left, right)

print(mergeSort(sample))
