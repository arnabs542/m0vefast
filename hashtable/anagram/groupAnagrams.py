# solution1: sort + hashmap
# //当两个string排序以后相同，则它们是anagrams。这样anagrams会有相同的key
# //可以使用一个hashtable，string s的key是它自己排序后的string，
# //这样anagrams会有相同的key。用一个vector<int>来记录相同key的string
# //在input vector<string>中的index。最后扫描一遍hashtable，
# //当有两个或以上string有相同的key时，将它们输出到结果。

# 类似 anagrams
def groupAnagrams(strs):
	dict = {}
	for str in strs:
		sortedItem = ''.join(sorted(str))
		dict[sortedItem] = dict.get(sortedItem,[]) + [str]  # each value is a list not str
	return [each for each in dict.values()]

def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
	if strs is None or not strs:
		return []
	dic = collections.defaultdict(list)
	for str in strs:
		sorted_item = ''.join(sorted(str))
		dic[sorted_item].append(str)

	return [each for each in dic.values()]




# {'333': ['333']}
# {'333': ['333'], 'aab': ['aba']}
# {'333': ['333'], 'aab': ['aba', 'baa']}
# dict.values()
# [['333'], ['aba', 'baa']]
