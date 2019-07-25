def solveNQueens(self, n: int) -> List[List[str]]:
	res = []
	self.dfs(res, [], n)
	return res

def dfs(self, res, cols, n):
	# branching factor: candidate col index for current row
	# depth: 9 row
	if len(cols) == n:
		res.append(self.render(cols))
		return
	# rows = len(path)
	for each_col in range(n):
		if self.is_valid(cols, each_col):
			self.dfs(res, cols + [each_col], n)

def is_valid(self, cols, each_col):
	for each_row in range(len(cols)):
		if cols[each_row] == each_col or abs(cols[each_row] - each_col) == abs(each_row - len(cols)):
			return False
	return True

def render(self, cols):
	rows = len(cols)
	board = []
	for row in range(rows):
		cur_row = ['Q' if j == cols[row] else '.' for j in range(rows)]
		board.append("".join(cur_row))
	return board
