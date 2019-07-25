class Solution:
    def word_search2(board, words):
        res = set()
        self.dir = [(1,0),(-1,0),(0,-1),(0,1)]

        trie = Trie()
        for word in words:
            trie.insert(word)

        node = trie.root
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, i, j, node, res, "")

        return list(res)

    def dfs(self, board, i, j, node, res):
        if node.is_word:
            res.add(path)
            # dupliate 

        if not self.isValid(board, i, j):
            return

        temp = board[i][j]
        node = node.get(temp)
        if node is None:
            return

        board[i][j] = "*"
        for d in self.dir:
            newx = i + d[0]
            newy = j + d[1]
            self.dfs(board, newx, newy, node, res, path+temp)
        board[i][j] = temp
        return

    def isValid(self, board, i, j):
        return 0 <= i < len(board) and 0 <= j < len(board[0])

class TrieNode:
    def __init__(self):
        self.children = {}
        seld.is_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for each in word:
            if each not in node.children:
                children[each] = TrieNode()
            node = node.children[node]
        node.is_word = True

    def search(self, word):
        node = self.root
        for each in word:
            node = node.children.get(each)
            if node is None:
                return False
        return node.is_word
