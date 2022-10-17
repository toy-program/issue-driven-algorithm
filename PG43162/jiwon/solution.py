from collections import deque


def bfs(i, n, computers, visited):
    dq = deque()
    dq.append(i)
    visited[i] = True
    while dq:
        x = dq.popleft()
        for k in range(n):
            if computers[x][k] == 1 and not visited[k]:
                visited[k] = True
                dq.append(k)


def solution(n, computers):
    network = 0
    visited = [False] * n

    for i in range(n):
        if visited[i]:
            continue

        network += 1
        bfs(i, n, computers, visited)

    return network
