# depth: # of unfilled spots
# branching factor: for possible number

'''
1) find the first unassiged spot as base case
2) for each branching factor:
    3) check valid
    4) dfs()
'''
def solveSudoku(board):
    dfs(board)

def dfs(board):
    row, col = findFirstUnassigned(board)
    # base case
    if (row, col) == (-1, -1):
        return True    # all solved
    for number in map(str, range(1, 10)):    # apply str(x) to each x collections
        if isvalid(board, row, col, number):
            board[row][col] = number
            if dfs(board):
                return True
            else:
                board[row][col] = '.'

def isvalid(board, row, col, number):
    rowsafe = all(board[row][_] != number for _ in range(9))
    colsafe = all(board[_][col] != number for _ in range(9))
    subgridsafe = all(board[r][c] != number for r in gerRange(row) for c in getRange(col))
    return rowsafe and colsafe and subgridsafe

def gerRange(x):
    x -= x % 3
    return range(x, x+3)

def findFirstUnassigned(board):
    for row in range(9):
        for col in range(9):
            if board[row][col] == '.':
                return row, col
    return -1, -1
