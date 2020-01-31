# iterative
def spiralOrderTraversal1(matrix):
	if matrix is None or not matrix:
		return []
	res = []
	start = 0
	end = len(matrix) - 1
	while start < end:
		for i in range(start, end):
			res.append(matrix[start][i])
			i += 1
		for i in range(start, end):
			res.append(matrix[i][end])
			i += 1
		for i in range(end, start, -1):
			res.append(matrix[end][i])
			i -= 1
		for i in range(end, start, -1):
			res.append(matrix[i][start])
			i -= 1
		start += 1
		end -=1
	if start == end:
		res.append(matrix[start][end])
	return res


#solution: too pythonic..... iterative O(n^2)
def spiralOrderTraversal1(square_matrix):
    def matrix_layer_in_clockwise(offset):
        # at odd dimension, then we are at the center of the matrix
        if offset == len(square_matrix) - offset - 1:
            spiral_ordering.append(square_matrix[offset][offset])
            return
        spiral_ordering.extend(square_matrix[offset][offset:-1 - offset])
        spiral_ordering.extend(
            list(zip(*square_matrix))[-1 - offset][offset:-1 - offset]
        )
        spiral_ordering.extend(square_matrix[-1 - offset][-1 - offset:offset:-1])
        spiral_ordering.extend(
            list(zip(*square_matrix))[offset][-1 - offset:offset:-1]
        )


    spiral_ordering = []
    for offset in range((len(square_matrix) + 1) // 2):
        matrix_layer_in_clockwise(offset)
    return spiral_ordering



def spiralOrderTraversal2(matrix):
	if matrix is None or not matrix:
		return []
	res = []
	left = 0
	right = len(matrix[0]) - 1
	up = 0
	bottom = len(matrix) - 1

	while left < right and up < bottom:
		for i in range(left, right):
			res.append(matrix[left][i])
			i += 1
		for i in range(up, down):
			res.append(matrix[i][right])
			i += 1
		for i in range(right, left, -1):
			res.append(matrix[down][i])
			i -= 1
		for i in range(down, up, -1):
			res.append(matrix[i][left])
			i -= 1
		left += 1
		right -= 1
		up += 1
		down -= 1

	if left <= right:
		for i in range(left, right + 1):
			res.append(matrix[up][i])
			i += 1
	if up <= down:
		for i in range(up, down +1):
			res.append(matrix[i][left])
			i += 1
	return res


def spiralOrderGeneration1(n):
	matrix = [[0] * n for i in range(n)]
	num = 1
	start = 0
	end = n-1

	while start < end:
		for i in range(start, end):
			matrix[start][i] = num
			num += 1
		for i in range(start, end):
			matrix[i][end] = num
			num += 1
		for i in range(end, start, -1):
			matrix[end][i] = num
			num += 1
		for i in range(end, start, -1):
			matrix[i][start] = num
			num += 1
		start += 1
		end -= 1

	if start == end:
		matrix[start][end] = num

	return res


def spiralOrderGeneration2(m, n):   # 3 col , 4 row
	matrix = [[0] * m for i in range(n)]
	num = 1
	left = 0
	right = m - 1 # 0, 1, 2
	up = 0
	down = n - 1

	while start < end and up < down:
		for i in range(start, end):
			matrix[start][i] = num
			num += 1
		for i in range(up, down):
			matrix[i][end] = num
			num += 1
		for i in range(end, start, -1):
			matrix[end][i] = num
			num += 1
		for i in range(end, start, -1):
			matrix[i][start] = num
			num += 1
		start += 1
		end -= 1
		up += 1
		down -= 1


	# not entering while loop ????
	if start > end or up > down:
		return matrix

	if left <= right: 
		for i in range(left, right+ 1):
			matrix[up][i] = num
			num += 1
			i += 1

	if up <= down:
		for i in range(up, down + 1):
			matrix[i][left]= num 
			num += 1
			i += 1

	return matrix


