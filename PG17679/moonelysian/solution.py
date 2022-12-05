import collections 

def solution(m, n, board):
    answer = 0
    position = set()
    board = [list(i) for i in board]

    def check(b):
        for i in range(m-1):
            for j in range(n-1):
                if b[i][j] == b[i+1][j] == b[i][j+1] == b[i+1][j+1] != '0':
                    position.add((i,j))
                    position.add((i+1,j))
                    position.add((i,j+1))
                    position.add((i+1,j+1))

    def arrange(b):
        for j in range(len(b[0])):
            q = collections.deque([])

            for i in range(len(b)-1,-1,-1):
                if b[i][j] == '0':
                    q.append((i,j)) 
                else:
                    if q:
                        qi, qj  = q.popleft()
                        b[qi][qj] = b[i][j]
                        b[i][j] = '0'
                        q.append((i, j)) 

    while True:
        check(board)
        if position:
            for i, j in position:
                board[i][j] = '0'
            answer += len(position)
            arrange(board)
            position.clear()
        else:
            break
    return answer