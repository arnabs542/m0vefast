def isValidSudoku(self, board):
    row = [set([]) for i in range(9)]
    col = [set([]) for i in range(9)]
    grid = [set([]) for i in range(9)]

    for each_row in range(9):
        for each_col in range(9):
            # check vertical and horizontal
            # empty
            if board[each_row][each_col] == '.':
                continue
            if board[each_row][each_col] in row[each_row]:
                return False
            if board[each_row][each_col] in col[each_col]:
                return False

            # check sub matrix
            each_grid = (each_row // 3) * 3 + (each_col // 3)   # submatrix index
            if board[each_row][each_col] in grid[each_grid]:
                retur False

            # ADD element
            row[each_row].add(board[each_row][each_col])
            col[each_col].add(boar[each_row][each_col])
            grid[each_grid].add(boar[each_row][each_col])

    return True
