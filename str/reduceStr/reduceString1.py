# remove duplicate and only keep one:
def reduceString1(str):
	if input is None or not input:
        return input

    arr = list(input)
    slow = 0
    for fast in range(1, len(arr)):
        if arr[slow] != arr[fast]:
            slow += 1
            arr[slow] = arr[fast]

    return ''.join(arr[:slow+1])




# Input: "bcabc"
# Output: "abc"
def reduceString1(str):
	if str is None or not str:
		return str
	counter = Counter(s)
	stack = []
	for c in s:
		if c not in stack:
			while stack and counter[stack[-1]] > 1 and stack[-1] >= c:
				counter[stack[-1]] -= 1
				stack.pop()
			stack.append(c)
		else:
			counter[c] -= 1
	return "".join(stack)
