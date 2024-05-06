sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]

def insertionSort(data):
    """
    삽입 정렬(Insertion Sort)
    최선의 경우 : O(N) 시간 복잡도
    최악의 경우 : O(N^2) 시간 복잡도
    """
    for i in range(1, len(data)):
        for j in range(i, 0, -1):
            if data[j-1] > data[j]:
                data[j-1], data[j] = data[j], data[j-1]

insertionSort(sample)
print(sample)
