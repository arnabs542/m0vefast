# O(n^2 * 4 * 3^(k-1)) = O(n^2 * 3^k), 3 is can not move back one you move next
# O(n)
def wordSearch1(board, word):
    self.dir = [(0,1), (0,-1), (1, 0), (-1,0)]
    for i in range(len(board)):
        for j in range(len(board[0])):
            if dfs(board, i, j, word, 0):
                return True
    return False

def dfs(board, i, j, word, index):
    if index >= len(word):
        return True

    if not isValid(board, i, j):
        return False

    if board[i][j] != word[index]:
        return False

    # branching factors: for directions to continue
    # depth: length of the target word
    char = board[i][j]
    board[i][j] = "*"  # every fresh try since depth0 can not use same spot
    for d in self.dir:
        newx = i + d[0]
        newy = j + d[1]
        if dfs(board, newx, newy, word, index+1):
            return True
    board[i][j] = char

    return False


def isValid(board, i, j):
    return 0 <= i < len(board) and 0 <= j < len(board[0])

# another solution: consistent
def wordsearch1(board, word):
    if word == []:
        return True
    if board is None or not board:
        return False
    self.dir = [(0,1), (0,-1), (1, 0), (-1,0)]

    for i in range(len(board)):
        for j in range(len(board[0])):
            if dfs(board, i, j, word, set(), 0):
                return True
    return False

def dfs(board, i, j, word, visited, index):
    if index >= len(word):
        return True

    if not isValid(board, i, j) or (i, j) in visited:
        return False
    if board[i][j] != word[index]:
        return False

    visited.add((i,j))
    for d in self.dir:
        newx = i + d[0]
        newy = j + d[1]
        if dfs(board, newx, newy, word, visited, index+1):
            return True
    visited.remove((i,j))
    return False
