def rotateMatrix(matrix):
    n = len(matrix)
    # y=x
    for i in range(n):
        for j in range(i+1, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    # x = 0
    for i in range(n):
        matrix[i].reverse()
