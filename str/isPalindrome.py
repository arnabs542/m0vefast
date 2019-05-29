def is_palindrome(str):
	str = re.sub('[^0-9a-zA-Z]', '', str).lower()
	return str == [::-1]

def is_palindrome(str):
	return all(str[i] == str[~i] for i in range(len(str) // 2))
	# ~i is the mirrow index of i     ~i = -(i+1)
