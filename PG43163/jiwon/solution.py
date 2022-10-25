minVal = int(1e9)


def dfs(depth, now, n, visited, words, target):
    global minVal
    if now == target:
        minVal = min(minVal, depth)
        return

    nodes = getNodeToVisit(now, visited, words)

    for idx, node in nodes:
        visited[idx] = True
        dfs(depth + 1, node, n, visited, words, target)
        visited[idx] = False


def getNodeToVisit(now, visited, words):
    nodes = []
    for i in range(len(words)):
        if not visited[i]:
            if getDiffNum(now, words[i]) == 1:
                nodes.append((i, words[i]))
    return nodes


def getDiffNum(x, y):
    diff = 0
    for i, j in zip(x, y):
        if i != j:
            diff += 1
    return diff


def solution(begin, target, words):
    dfs(0, begin, len(begin), [False] * len(words), words, target)
    if minVal == int(1e9):
        return 0
    return minVal
