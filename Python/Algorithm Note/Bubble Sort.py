sample = [3, 0, 1, 8, 7, 2, 5, 4, 6, 9]

def bubbleSort(data):
    """
    버블 정렬(Bubble Sort)
    평균 시간 복잡도 : O(N^2)
    """
    for i in range(len(data)-1):
        for j in range(i):
            if data[j] > data[j+1]:
                data[j], data[j+1] = data[j+1], data[j]
    return data

bubbleSort(sample)
print(sample)
