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
    if board[i][j] != word[index]:  # only for the first call
        return False

    if index == len(word)-1:
        return True

    # branching factors: for directions to continue
    # depth: length of the target word
    char = board[i][j]
    board[i][j] = "*"

    for d in self.dir:
        newx = i + d[0]
        newy = j + d[1]
        if isValid(board, newx, newy) and board[newx][newy] == word[index+1]:
            if dfs(board, newx, newy, word, index+1):
                return True

    board[i][j] = char
    return False


def isValid(board, i, j):
    return 0 <= i < len(board) and 0 <= j < len(board[0])
