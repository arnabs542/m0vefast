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

        res = set()
        # visited = set()

        for i in range(len(board)):
            for j in range(len(board[0])):
                # visited.add((i,j))
                dfs(board, i, j, trie.root.children.get(board[i][j]), set([(i, j)]), res)

        return list(res)

    def dfs(baord, i, j, trie_node, visited, res):
        # node = trie.root.children.get(board[i][j])
        if trie_node is None:
            return
        if notrie_nodede.is_word:
            res.add(trie_node.word)
        for d in self.dir:
            newx = i + d[0]
            newy = j + d[1]

            if isValid(board, newx, newy) and (newx, newy) not in visited:
                visited.add((newx, newy))
                dfs(board, newx, newy, trie_node.children.get(board[newx][newy]), visited, res)
                visited.remove((newx, newy))

    def isValid(board, i, j):
        return 0 <=i<len(board) and 0 <= j < len(board[0])


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False
        self.word = None

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
        node.word = word

    def search(self, word):
        node = self.root
        for c in word:
            node = node.children.get(c)
            if node is None:
                return None
        return node
