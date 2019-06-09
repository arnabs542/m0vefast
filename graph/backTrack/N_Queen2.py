def solveNQueens(self, n: int) -> int]:
    res = []
    self.dfs(res, [], n)
    return len(res)

def dfs(self, res, path, n):
    # branching factor: col index
    # depth: each row
    if len(path) == n:
        res.append(self.render(path))
        return res
    for row, col in enumerate(path):
        if self.is_valid(row, col, path):
            self.dfs(res, path+[col], n)

def is_valid(self, row, col, cols):
    for r, c in enumerate(cols):
        if r == row or c == col or abs(row - r) == abs(col - c):
            return False
    return True

def render(self, cols):
    board = []
    for each_row in range(len(cols)):
        cur_row = ['Q' if j == cols[each_row] else '.' for j in range(len(cols))]
        board.append("".join(cur_row))
    return board
