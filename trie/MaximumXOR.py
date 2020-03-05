# O(n)
def findMaxXOR(nums):
	self.trie = Trie()
	max_xor = -2**(32)

	for each in nums:
		binary = (bin[each][2:]).zfill(31)     # keep leading zero with zfill (representing with 31 bit number) # -> in binary form: '0b11'
		self.trie.insert(binary, each)
		max_xor = max(max_xor, self.trie.search(bianry, each))

	return max_xor


class TrieNode:
	def __init__(self):
		self.children = {}
		self.is_end = False
		self.value = 0

class Trie:
	def __init__(self):
		self.root = TrieNode()

	def insert(self, word, val):
		node = self.root
		for each in word:
			if each not in node.children:
				node.children[each] = TrieNode()
			node = node.children[each]
		node.is_end = True
		node.value = val

	def search(self, word, target):
		node = self.root
		for each in word:

			if each == '1' and node.children.get("0"):
				node = node.children.get("0")
			elif each == "0" and node.children.get("1"):
				node = node.children.get("1")
			elif node.children.get(each):
				node = node.children.get(each)
			else:
				break   # reach to the end or no any path yet 

		return target^node.value    # ^ binary xor value 

# target is the curretn number
# node is the previous number that form xor with target










			

