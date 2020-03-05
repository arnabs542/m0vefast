def longestWord(words):
	trie = Trie()
	for each in words:
		trie.insert(each)

	return trie.bfs()

def bfs(self):
	queue = collecitons.deque([self.root])
	res = ""
	while queue:
		node = queue.popleft() 
		for each in node.children.values():   # check the trie itself not each word
			if each.is_end:
				queue.append(each)
				if len(each.word) > len(res) or each.word < res:  # length and lexicography 
					res = each.word

	return res