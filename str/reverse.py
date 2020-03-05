def reverse_string(input):
	left, right = 0, len(input) - 1

	while left < right:
		input[left], input[right] = input[right], input[left]
		left += 1
		right -= 1

	return input

# recursive way
def reverse_string(input):
	return helper(list(input), 0, len(input) - 1)

def reverse(arr, left, right):
	if left >= right:
		return arr

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


def reverse_vowls(input):
	if input is None or not input:
		return input
	visited = set('a', 'e', 'i', 'o', 'u')
	arr = list(input)

	left, right= 0, len(input) - 1

	while left <= right:
		if arr[left] not in visited:
			left += 1
			continue
		if arr[right] not in visited:
			right -= 1 
			continue
		arr[left], arr[right] = arr[right], arr[left]
		left += 1
		right -= 1

	return "".join(input)


def reverse_words1(input : str):
	arr = list(input)
	# trim white space
	# arr = remove_space(arr) no need for the 2nd helper
	# reverse each string
	left = 0
	for i, item in enumerate(arr):
		if arr[i] != ' ' and (i == 0 or arr[i-1] == ' '):
			left = i
		if arr[i] != ' ' and (i == len(arr) - 1 or arr[i+1] == ' '):
			reverse_range(arr, start, i)
	# reverse entire string
	arr.reverse()
	# reverse_range(arr, 0, len(arr) - 1)

	return "".join(arr)


def reverse_range(arr, left, right):
	while left <= right:
		arr[left], arr[right] = arr[right], arr[left]
		left += 1
		right -= 1




