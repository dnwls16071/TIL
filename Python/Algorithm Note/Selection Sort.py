sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]

def selectionSort(data):
    """
    선택 정렬(Selection Sort)
    시간 복잡도 : O(N^2)
    """
    for i in range(len(data)):
        idx = i
        for j in range(i+1, len(data)):
            if data[j] < data[idx]:
                idx = j
        data[i], data[idx] = data[idx], data[i]
    return data

selectionSort(sample)
print(sample)
