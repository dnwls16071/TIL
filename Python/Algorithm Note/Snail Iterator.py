def solution(n):
    answer = [[0] * n for _ in range(n)]
    seq = (n * (n+1)) // 2
    # 나선형(아래쪽 → 오른쪽 → 왼쪽 위 대각선)
    # 반시계 방향
    dy = [1, 0, -1]
    dx = [0, 1, -1]
    y = 0; x = 0; direction = 0
    cnt = 1
    
    while cnt <= seq:
        answer[y][x] = cnt
        ny = y + dy[direction]
        nx = x + dx[direction]
        cnt += 1
        
        if (0 <= ny < n) and (0 <= nx < n) and answer[ny][nx] == 0:
            y, x = ny, nx
        else:
            direction = (direction + 1) % 3
            y += dy[direction]
            x += dx[direction]
    return answer
