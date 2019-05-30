#pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
# recursion
def abbrMaching(input, pattern):
	return helper(list(input), list(pattern), 0, 0)
def helper(source, pattern, si, pi):
	# base case
	if si == len(source) and pi == len(pattern):
		return True
	if si >= len(source) or pi >= len(pattern):   # has to be >= not >
		return False

	# check if t is char
	if pattern[pi] < '0' or pattern[pi] > '9':     # if not str.isDigit()
		if pattern[pi] == source[si]:
			helper(source, pattern, si+1, pi+1)
		else:
			return False
	else: # check if t is a char
		count = 0
		while pi < len(pattern) and pattern[pi] >= '0' and pattern[pi] <= '9':
			count = count * 10 + (ord(pattern[pi]) - ord('0'))
			pi += 1
		return helper(source, pattern, si+count, pi)
