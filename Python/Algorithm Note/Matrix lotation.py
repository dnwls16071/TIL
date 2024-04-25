def rotate(graph, x1, y1, x2, y2):
    min_value = graph[x1][y1]
    first = min_value

    # 왼쪽 면
    for i in range(x1, x2):
        graph[i][y1] = graph[i+1][y1]
        min_value = min(min_value, graph[i+1][y1])

    # 아래쪽 면
    for j in range(y1, y2):
        graph[x2][j] = graph[x2][j+1]
        min_value = min(min_value, graph[x2][j+1])

    # 오른쪽 면
    for k in range(x2, x1, -1):
        graph[k][y2] = graph[k-1][y2]
        min_value = min(min_value, graph[k-1][y2])

    # 위쪽 면
    for m in range(y2, y1+1,-1):
        graph[x1][m] = graph[x1][m-1]
        min_value = min(min_value, graph[x1][m-1])

    graph[x1][y1+1] = first
    return min_value
