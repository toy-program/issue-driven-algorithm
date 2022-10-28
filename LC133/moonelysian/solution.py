def cloneGraph(self, node: 'Node') -> 'Node':
    if not node:
        return node
    
    deq = deque([node])
    nodes = {node.val: Node(node.val)}
    
    while deq:
        poped = deq.popleft()
        current = nodes[poped.val]
        
        for neighbor in poped.neighbors:
            if neighbor.val not in nodes:
                nodes[neighbor.val] = Node(neighbor.val)
                deq.append(neighbor)
            
            current.neighbors.append(nodes[neighbor.val])
        
    return nodes[node.val]