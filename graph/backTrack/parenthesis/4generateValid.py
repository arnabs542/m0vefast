'''
[((()))", "(()())", "(())()", "()(())", "()()()"]    # n pairs of
when we can add a (? whenever there is some ( we can still use
when we can add a )? when there is more ( than ) used
'''
def generateValidParenthesis(n):
	if n <= 0:
		return []
	res = []
	dfs(res, n//2, n//2, "")
	return res

def dfs(res, left, right, path):
	# depth: all left and right used up
	if left == 0 and right == 0:
		res.append(path)
		return

	if left > 0:
		dfs(res, left-1, right, path+"(")
	if right > left:
		dfs"(res, left, right-1, path+")")
