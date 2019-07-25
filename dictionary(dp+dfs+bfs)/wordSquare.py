# Given a set of words (without duplicates), find all word squares you can build from them.
# https://www.cnblogs.com/EdwardLiu/p/6201232.html
class Solution:
    def allWordSquares(words):
        trie = Trie()
        res = []
        for word in words:
            trie.insert(word)

        for word in words:
            self.dfs(trie, [word], res)
        return res

    def dfs(trie, path, res):
        cur_index = len(path)
        if cur_index == len(path[0]):
            res.append(path)
            return
        prefix = ''.join([path[i][cur_index] for i in range(cur_index)])
        for word in prefix:
            self.dfs(trie, path+[word], res)
            

    # is valid word square
    def validWordSquare(self, words: List[str]) -> bool:
    # is sqaure and 90- retational
        for i in range(len(words)):
            for j in range(len(words[i])):
                # is square          # more row then corresponding col lenght
                if j >= len(words) or i >= len(words[j]) or words[i][j] != words[j][i]:  # not mirror (y = -x)
                                     # top_right --- bottom_left mirrow
                    return False
        return True



class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False
        self.word_list = []

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
                node.word_list.append(word)
        node.is_word = True

    def search(self, prefix):
        node = self.root
        for w in prefix:
            node = node.children.get(w)
            if node is None:
                return None
        return node

    def startswith(self, prefix):
        node = self.search(prefix)
        return [] if node is None else node.word_list



'''
Input:
[
  "b a l l",
  "a r e a",
  "r e a d",
  "l a d y"
]

Output:
false

Input:
[
  "a b c d",
  "b n r t",
  "c r m",
  "d t"
]

Output:
true
'''
