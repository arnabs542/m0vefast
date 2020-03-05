class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False
# trie with nodes 
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for each in word:
            if each not in node.children:
                node.children[each] = TrieNode()
            node = node.children[node]
        node.is_word = True

    def search(self, word):
        node = self.root
        for each in word:
            node = node.children.get(each)
            if node is None:
                return False
        return node.is_word

# prefix is a valid prefix in the trie
    def startWith(self, prefix):
        node = self.root
        for each in prefix:
            if each not in node.children:
                return False
            node = node.children[each]
        return True






Q: check words in a dictionary
# node
# map<char, trie> children
# numberOfWords # below
# end     # is this a word 

def insert(str, cur, root):
	if cur == str.size:
		return root.numberOfWords += 1

	insert(str, cur+1, root.children[str[cur]])
	root.numberOfWords += 1


def query(str, cur, root):
	if cur == str.size:
		return root.end

	if root.children.count(str[cur]):
		return query(str, cur + 1, root.chldren[str[cur]])

	return False


