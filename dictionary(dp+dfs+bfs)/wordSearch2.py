'''
Time: O(m * n * wl) = max(O(l * wl), O(m * n * l * wl)) where
O(l * wl) - Build the trie
O(wl) - search a word in the trie
O(m * n * l * wl) - In the worst case where all words start with different chracters,
and there is a word starting with a character in the cell board[m - 1][n - 1], we have O(m * n * l * wl).
However, if there are words starting with same characters and paths sharing cells,
Trie can check multiple words when DFS from a certain cell, rather than check only one word when DFS from a certain cell like the naive way.

Space: O(l * wl) = max(O(wl), O(l * wl)) where
O(wl) - The recursive stack can grow at most to wl layers.
O(l * wl) - In the worst case when all words start with different characters,
the trie has l * wl nodes. Also, since each word is stored in a leaf node, all the leaf nodes require l * wl memory.
'''

class Solution:
    def wordSearch2(board, words):
        if board is None or len(board) == 0:
            return []

        self.dir = [(1,0),(-1,0),(0,1),(0,-1)]

        trie = Trie()
        for word in words:
            trie.insert(word)
        node = trie.root
        res = set()

        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(board, i, j, node, res, "")
        return list(res)

    def dfs(baord, i, j, node, res, path):
        if node.is_word:
            res.add(path)
            # node.is_word = false
            '''
            - since we already completed that word and added in our result array, we don't want to get duplicates of that
            word so we set it to False.
            - Example ['aaa','aaab'] after adding 'aaa' when we search for 'aaab' we will add 'aaa' again if we
            don't set it to False, so we avoid that by setting it to False.
                '''

        if not isValid(board, i, j):
            return

        char= board[i][j]
        node = node.children.get(char)
        if node is None:
            return

        board[i][j] = "*"
        for d in self.dir:
            newx = i + d[0]
            newy = j + d[1]
            self.dfs(board, newx, newy, node, res, path+char)
        board[i][j] = char


    def isValid(board, i, j):
        return 0 <=i<len(board) and 0 <= j < len(board[0])


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.is_word = True

    def search(self, word):
        node = self.root
        for w in word:
            node = node.children.get(w)
            if node is None:
                return False
        return node.is_word
