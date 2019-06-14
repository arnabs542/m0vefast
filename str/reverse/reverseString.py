#iterative
def reverseStr(input):
	# input.reverse()
	left = 0
	right = len(input) - 1
	arr = list(input)
	while left < right:
		arr[left], arr[right] = arr[right], arr[left]
	input[:] = ''.join(arr)
	return input

#recursive
def reverseStr(input):
	return self.helper(list(input), 0, len(input) - 1)

def helper(arr, left, right):
	if left >= right:
		return ''.join(arr)

	if left <  right:
		arr[left], arr[right] = arr[right], arr[left]
		helper(arr, left+1, right-1)


# followup 1
'''
Input: s = "ab cd    ef g", k = 2
Output: "ba cd fe g"
Given a string and an integer k, you need to reverse the first k characters for every 2k characters
counting from the start of the string. If there are less than k characters left, reverse all of them.
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
'''
def reverseStrk(s, k):
	s = list(s)
	for i in range(0, len(s), 2*k):
		s[i:i+k] = reversed(s[i:i+k])
	return ''.join(s)
