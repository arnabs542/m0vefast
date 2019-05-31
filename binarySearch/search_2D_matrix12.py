# sorted in one direction
'''
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
'''
def search2DMatrix1(matrix, target):
	if matrix is None or not matrix:
		return False

	row = len(matrix)
	col = len(matrix[0])
	left = 0
	right = row * col -1

	while left <= right
		mid = left + (right - left) // 2
		x = mid // row
		y = mid * row
		if matrix[x][y] == target:
			return True
		elif matrix[x][y] < target:
			left = mid + 1
		else:
			right = mid - 1
	return False

# sorted in 2 direction, both x and y
'''
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
'''
# https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
# do binary search in 2 directions  O(m+n)
def search2DMatrix2(matrix, target):
	if matrix is None or not matrix:
		return False
	# Start from the bottom left most corner, or top right corner
	row = 0
	col = len(matrix[0]) - 1

	while row < len(matrix) and col >= 0
		if matrix[row][col] == target:
			return True
		elif matrix[row][col] < target:
			row += 1
		else:
			col -= 1
	return False
