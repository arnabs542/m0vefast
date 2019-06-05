# solution: iterative
def spiralGenerate1(n):
	matrix = [[0]*n for i in range(n)]
    num = 1
    start = 0
    end = n-1

    while start < end:
        for i in range(start, end):
            matrix[start][i] = num
            num += 1
            i += 1
        for i in range(start, end):
            matrix[i][end] = num
            num += 1
            i += 1
        for i in range(end, start, -1):
            matrix[end][i] = num
            num += 1
            i -= 1
        for i in range(end, start, -1):
            matrix[i][start] = num
            num += 1
            i -= 1
        start += 1
        end -= 1

    if start == end:
        matrix[start][end] = num

    return matrix
