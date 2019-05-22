def spiralGenerate1(m,n):
	matrix = [[0]*n for i in range(m)]   #n col and m row
	num = 1
	left = 0
	right = n-1
	up = 0
	right = m-1

	while left < right and up < down:
		for i in range(left, right):
			matrix[left][i] = num
			num += 1
			i += 1
		for i i range(up, down):
			matrix[i][right] = num
			num += 1
			i += 1
		for i in range(right, left, -1):
			matrix[down][i] = num
			num += 1
			i -= 1
		for i in range(down, up, -1):
			matrix[i][left] = num
			num += 1
			i -= 1

		left += 1
		right -= 1
		up += 1
		down -= 1

	if left > right or up > down:
		return matrix

	if left == right:
		for i in range(up, down+1):
			matrix[up][i] = num
			num += 1
			i+= 1

	else:
		for i in range(left, right+1):
			matrix[i][left] = num
			num += 1
			i += 1

	return matrix
