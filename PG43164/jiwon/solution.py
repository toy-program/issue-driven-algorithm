from collections import defaultdict
import copy

START_CITY = "ICN"
ticketNum = 0
answer = []

def dfs(city, graph, visited, path):
    global answer

    if len(path) == ticketNum + 1:
        if not answer:
            answer = copy.deepcopy(path)
        return

    for idx, element in enumerate(graph[city]):
        if not visited[city][idx]:
            path.append(element)
            visited[city][idx] = True
            dfs(element, graph, visited, path)
            visited[city][idx] = False
            path.pop()

def solution(tickets):
    global ticketNum
    ticketNum = len(tickets)

    graph = defaultdict(list)

    for start, dest in tickets:
        graph[start].append(dest)

    visited = dict()
    for city in graph.keys():
        graph[city].sort()
        n = len(graph[city])
        visited[city] = [False] * n

    dfs(START_CITY, graph, visited, [START_CITY])

    return answer
