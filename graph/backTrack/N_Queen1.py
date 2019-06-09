def solveNQueens(self, n: int) -> List[List[str]]:
	res = []
	self.dfs(res, [], n)
	return res

def dfs(self, res, path, n):
	# branching factor: choose which col index
	# depth: for each row
	if len(path) == n:
		res.append(self.render(path))
		return
	for row, col in enumerate(path):
		if self.is_valid(path, row, col):
			self.dfs(res, path + [col], n)

def is_valid(self, cols, row, col):
	for r, c in enumerate(cols):
		if col == c or row == r or abs(col - c) == abs(row - r):
			return False
	return True

def render(self, cols):
	rows = len(cols)
	board = []
	for row in range(rows):
		cur_row = ['Q' if j == cols[row] else '.' for j in range(rows)]
		board.append("".join(cur_row))
	return board
