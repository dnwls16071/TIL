sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]

def quickSort(data, low, high):
    """
    중앙을 기점으로 왼쪽과 오른쪽으로 나눈다.
    """
    pivot = data[(low + high) // 2]
    left, right = low, high
    """
    왼쪽에서부터 탐색하여 피벗보다 큰 값과 오른쪽에서부터 탐색하여 피벗보다 작은 값, 이 두 값을 교체한다.
    """
    while True:
        while data[left] < pivot:
            left += 1
        while data[right] > pivot:
            right -= 1
        if left >= right:
            break
        data[left], data[right] = data[right], data[left]
    """
    피벗 기준 왼쪽 부분 배열(low ~ right)
    """
    if low < right:
        quickSort(data, low, right)
    """
    피벗 기준 오른쪽 부분 배열(right + 1 ~ high)
    """
    if left < high:
        quickSort(data, right+1, high)

quickSort(sample, 0, len(sample)-1)
print(sample)
