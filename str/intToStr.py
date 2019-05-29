# integer to string
# converting backwards, need to reverse
def toString(x):
	is_negative = False
	if x < 0:
		x = -x
		is_negavie = True
	res = []
	while True:
		res.append(chr(ord('0') + x % 10))   # 432, res.append(2), then 3, then 2   ord(0) in case x is 0 or 10...
		x // 10
		if x == 0:
			break
	return ('-' if is_negavie else '') + ''.join(reversed(res))


# string to integer
# converting forward
def stringToInteger(self, str):
	# Write your code here
	num, sig = 0, 1

	if str[0] == '-':
		sig = -1
		str = str[1:]   # O(n) tiem

	for c in str:
		num = num * 10 + (ord(c) - ord('0'))  # ascii number

	return num * sig
