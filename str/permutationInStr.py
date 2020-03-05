# https://leetcode.com/problems/permutation-in-string/
# if s2 contains a permutation of s1

# solution1: brute force 
def checkInclusion(s1, s2):
	# generate all permutation of s1
	arr = list(s1)
	res = []
	dfs(arr, res, 0)

	# check if one permutation in s2
	for each in res:
		if s2.find(each) != -1:
			return True
	return False

def dfs(arr, res, depth):
	if depth == len(arr):
		res.append("".join(arr[:]))
		return

	for index in range(depth, len(arr)):
		arr[depth], arr[index] = arr[index], arr[depth]
		self.dfs(res, arr, depth+1)
		arr[depth], arr[index] = arr[index], arr[depth]


# solution2: sliding window, find anagram
def checkInclusion(s1, s2):
	from collections import Counter   
	# window: s2-s1. ->.  end of s2

	d1, d2 = Counter(s1), Counter(s2[:len(s1)])
	for start in range(len(s1), len(s2)):
		if d1 == s2:
			return True
		d2[s2[start]] += 1
		d2[s2[start - len(s1)]] -= 1
		if d2[s2[start - len(s1)]] == 0:
			del d2[s2[start - len(s1)]]

	return d1 == d2

