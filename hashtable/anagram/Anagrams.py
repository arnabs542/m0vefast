def anagrams(strs):
	dict = {}
	for str in strs:
		sorteditem = ''.sorted(str)
		dict[sorteditem] = dict.get(sorteditem, []) + [str]
	#dict.value()   returns [][][] for each key
	# this question requires return as [aba, aba, cca, acc]
	res = []
	for each in dict.values():
		res += each
	return res
