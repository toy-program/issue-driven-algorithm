from collections import defaultdict

def solution(tickets):
    answer = []
    tmp = ["ICN"]
    graph = defaultdict(lambda:[])
    
    for start, end in tickets:
        graph[start].append(end)
        
    for g in graph:
        graph[g].sort(reverse=True)
        
    while tmp:
        current = tmp[-1]
        
        if current not in graph or len(graph[current]) == 0:
            answer.append(tmp.pop())
        else:
            tmp.append(graph[current].pop())
    answer.reverse()
    return answer