# solution1: O(mn)
def strStr(str, target):
	if str is None or target is None:
		return -1
	if len(target) > len(str):
		return -1
	if len(target) == 0:
		return 0

	for i in range(len(str) - len(target) + 1):
		# for j in range(len(target)):
		# 	if str[i+j] != target[j]:
		# 		j = 0
		# 		break
		j = 0
		while j < len(target):
			if source[j+i] != target[j]:
				# j = 0
				break
			else:
				j += 1

		if j == len(target):
			return i
	return -1

# solution2: O(m+n) average, O(mn) if collision(check at each same hash value)
# https://brilliant.org/wiki/rabin-karp-algorithm/
# robin karp with good hash function in linear time
def strStr(source, target):
	if len(target) > len(source):
		return -1
	if target == "" or len(source) == ""：
		return 0
	self.base = 10
	self.modeula = 100000007

	source_hash = self.rolling_hash(source, len(source))
	target_hash = self.rolling_hash(target, len(target))[-1]

	for i in range(len(target) - 1, len(source)):
		if i == len(needle) - 1:
			if source_hash == target_hash:
				return 0
		else:
			x = source_hash[i] -  self.pow(source_hash[i-len(target)], base, len(target))
			# if x < 0:
			# 	x = modeula - (-x)
			#. NEED TO MOD HERE !!!!!!!!
			if x % modeula == target_hash:
				return i - len(needle) + 1

def pow(self, num, base, times):
	for i in range(times):
		num = num * base
	return num

def rolling_hash(self, input, n):
	res = []
	res[0] = ord(input[0]) - ord("a") + 1

	for i in range(1, n):
		res[i] = (self.mul_helper(res[i-1], self.base, self.modeula)
					 + ord(input[i]) - ord("a") + 1)
					  % self.modeula
		return res

def mul_helper(self, num, base, modeula):
	retrun ((a % modeula) * (base % modeula)) % modeula











