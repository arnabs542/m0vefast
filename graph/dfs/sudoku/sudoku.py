def validSudoku(matrix):
	row = [set() for i in range(9)]
	col = [set() for j in range(9)]
	grid = [set() for k in range(9)]

	for each_row in range(9):
		for each_col in range(9):
			# check vertically and horizonally 
			# empty
			if matrix[each_row][each_col] == ".":
				continue
			if matrix[each_row][each_col] in row[each_row]:
				return False
			if matrix[each_row][each_col] in col[each_col]:
				return False

			# check submatrix
			# each_grid index
			each_grid = each_row // 3 * 3 + each_col // 3
			if matrix[each_row][each_col] in grid[each_grid]:
				return False

			# add element 
			row[each_row].add(matrix[each_row][each_col])
			col[each_col].add(matrix[each_row][each_col])
			grid[each_grid].add(matrix[each_row][each_col])

	return True

# pythonic solution using list compprehension
def sudokuChecker()



def sudokuSolver()


