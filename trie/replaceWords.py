# replace by dictionary
# https://leetcode.com/problems/replace-words/
def replaceWords(self, dict: List[str], sentence: str) -> str:
	arr = sentence.split(" ")
	for i in range(len(arr):
		for each in dict:
			if arr[i].startWith(each):
				arr[i] = each
	return " ".join(arr)



def replaceWords(self, dict, sentences):
	trie = Trie()
	for each in dict:
		trie.insert(each)

	words = []
	for each in sentence.split(" "):
		words.append(trie.search(each))

	return " ".join(words)



def find_prefix(self, word):
	node = self.root
	prefix = ''
	for each in word:
		prefix += each

		if each not in node.children:
			return word
		else:
			if node.children[each].is_end:
				return prefix
			else:
				node = node.children[each]

	# dictionary word is longer thatn the sentence word
	return word

'''
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
'''
