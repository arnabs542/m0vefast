#iterative
def reverseStr(input):
	# input.reverse()
	left = 0
	right = len(input) - 1
	while left < right:
		input[left], input[right] = input[right], input[left]
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
