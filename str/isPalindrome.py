def is_palindrome(str):
	str = re.sub('[^0-9a-zA-Z]', '', str).lower()
	return str == [::-1]

def is_palindrome(str):
	return all(str[i] == str[~i] for i in range(len(str) // 2))
	# ~i is the mirrow index of i     ~i = -(i+1)

def is_palindrome(str):
	# considering white space, char, upper/lower case
	import re
	str = re.sub("[^A-Za-z0-9]", "", str).lower()
	left, right = 0, len(str) - 1
	while left < right:
		if arr[left] != arr[right]:
			return False
		left += 1
		right -= 1
	return True


