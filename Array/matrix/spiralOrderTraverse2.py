def spiralOrderTraverse2(self, matrix: List[List[int]]) -> List[int]:
    res = []
    n = len(matrix)
    if n == 0:
        return res
    m = len(matrix[0])
    left = 0
    right = m-1
    up = 0
    down = n-1

    while left < right and up < down:
        for i in range(left, right):
            res.append(matrix[up][i])

        for i in range(up, down):
            res.append(matrix[i][right])

        for i in range(right, left, -1):
            res.append(matrix[down][i])

        for i in range(down, up, -1):
            res.append(matrix[i][left])

        left += 1
        right -= 1
        up += 1
        down -= 1

    # if left > right or up > down:
    #     return res

    if left == right:
        for i in range(up, down+1):
            res.append(matrix[i][right])

    else:
        for i in range(left, right+1):
            res.append(matrix[down][i])


    return res
