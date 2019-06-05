# solution: iterative
def spiralOrderTraverse1(self, matrix: List[List[int]]) -> List[int]:
    res = []
    n = len(matrix)
    start = 0
    end = n - 1
    while (start < end):
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
        end -= 1

    if start == end:
        res.append(matrix[start][end])
    return res


# solution: recursion [not tested]
def spiralOrderTraverse1(self, matrix: List[List[int]]) -> List[int]:
    res = []
    traverse(matrix, 0, len(matrix), res)
    return res

def traverse(matrix, offset, size, res):
    if size == 0:
        return
    if size == 1:
        res.append(matrix[offset][offset])
        return

    for i in range(0, size-1):
        res.append(matrix[offset][offset+i])
        i += 1
    for i in range(0, size-1):
        res.append(matrix[offset+i][offset+size-1])
        i += 1

    for i in range(size-1, 1, -1):
        res.append(matrix[offset+size-1][offset+i])
        i -= 1

    for i in range(size-1, 1, -1):
        res.append(matrix[offset+i][offset])
        i -= 1

    traverse(matrix, offset+1, size-2, res)






















#solution: too pythonic..... iterative O(n^2)
def spiral_generate(square_matrix):
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
