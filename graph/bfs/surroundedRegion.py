# surrounded region by X, how many O
# solution1: bfs from border, replace rest with X
def surroundedRegions(self, board):
    # write your code here
    if board is None or not board:
        return

    row = len(board)
    col = len(board[0])

    queue = collecitons.deque([])
    # initialization: mark border O into queue
    for r in range(row):
        for c in range(col):
            if (r in [0, row-1] or c in [0, col-1]) and board[r][c] == "O":
                queue.append((r,c))
    # expansion % generation
    while queue:
        x, y = queue.popleft()
        board[x][y] = 'D'
        for k in [(-1,0),(1,0),(0, -1),(0, 1)]:
            newx = x + k[0]
            newy = y + k[1]
            if self.isValid(board, newx, newy):
                queue.append((newx, newy))

    # mark original O as D and reverse the border O
    for r in range(row):
        for c in range(col):
            if board[r][c] == 'D':
                board[r][c] = 'X'
            else:
                board[r][c] = 'X'
def isValid(board, row, col):
    0 <= row < len(board) and 0 <= col < len(board[0]) and board[row][col] == 'O'
