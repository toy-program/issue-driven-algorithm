from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

AISLE = 1
WALL = 0

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]

    dq = deque()
    dq.append((0, 0))
    visited[0][0] = True

    while dq:
        x, y = dq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and maps[nx][ny] == AISLE:
                    maps[nx][ny] = maps[x][y] + 1
                    visited[nx][ny] = True
                    dq.append((nx, ny))

    if maps[n - 1][m - 1] == AISLE:
        return -1
    return maps[n - 1][m - 1]
