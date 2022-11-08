from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        dq = deque()
        graph = [[] for _ in range(numCourses)]

        for a, b in prerequisites:
            graph[a].append(b)
            indegree[b] += 1

        for idx, element in enumerate(indegree):
            if element == 0:
                dq.append(idx)

        while dq:
            now = dq.popleft()
            for x in graph[now]:
                indegree[x] -= 1
                if indegree[x] == 0:
                    dq.append(x)

        for node in indegree:
            if node != 0:
                return False

        return True