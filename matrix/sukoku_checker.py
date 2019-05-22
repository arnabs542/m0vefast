# check if a partially filled matrix has any conflicts
import math

# regular solution
def is_valid_sudoku(partial_matrix):
    def has_dupliate(block):        # check 0, partial filled matrix
        block = list(filter(lambda x: x != 0, block)) # The list() constructor returns a mutable sequence list of elements.
        return len(block) != len(set(block))

    # check row and col constrains
    '''how to iterate all elements of a square matrix'''
    n = len(partial_matrix)
    if any(has_dupliate([partial_matrix[i][j] for j in range(n)])   # all col of ith row
           or has_dupliate([partial_matrix[j][i] for j in range(n)])   # all row of ith col
           for i in range(n)):
        return False

    # check region constrain
    '''how to iterate all submatrix of a square matrix'''
    # TODO: duplication for the double for loop?
    region_size = int(math.sqrt(n))
    return all(not has_dupliate([partial_matrix[a][b]
                                 for a in range(region_size * ROW, region_size * (ROW + 1))
                                 for b in range(region_size * COL, region_size * (COL + 1))
                                 ]
                                )
               for ROW in range(region_size) for COL in range(region_size))
    '''
    if any(has_dupliate([partial_matrix[a][b]
                                 for a in range(region_size * ROW, region_size * (ROW + 1))
                                 for b in range(region_size * COL, region_size * (COL + 1))
                        ]
                       )
            for ROW in range(region_size) for COL in range(region_size)):
        return False
    return True
    '''




# pythonic solution using list compprehension
