'''
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
'''
def partition(self, s: str) -> List[List[str]]:
	res = []
	self.dfs(res, s, [])
	return res

def dfs(self, res, arr, path):
	if len(arr) = 0:
		res.append(path)
		return
    # branching facotr: cutting poing to form s[:i]
    # depth: length of the given string 
	for i in range(1, len(arr) + 1):
		prefix = arr[:i]
		if self.is_palindrome(prefix):
			self.dfs(res, arr[i:], path + [prefix])

def is_palindrome(self, s):
	return s == s[::-1]


https://www.jiuzhang.com/solution/palindrome-partitioning/#tag-highlight-lang-python
