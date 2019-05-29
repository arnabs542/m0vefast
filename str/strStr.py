# solution1: O(n^2)
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

class RollingHash:
	def __init__(self, source, sizetarget):
	        self.source = source
	        self.hash = 0
	        self.sizetarget = sizetarget
			self.left = 0
	        self.right = sizetarget

	        for i in range(0, sizetarget):
	            self.hash += (ord(self.source[i]) - ord("a") + 1)*(26**(sizetarget - i -1))

	def move_window(self):
		if self.right <= len(self.source) - 1:
			#remove left letter from hash value
			self.hash -= (ord(self.source[self.left]) - ord("a") + 1)*26**(self.sizetarget-1)
			self.hash *= 26
			self.hash += ord(self.source[self.right]) - ord("a") + 1
			self.left += 1
			self.right += 1

	def window_source(self):
		return self.source[self.left:self.right]



def rabin_karp(target, source):  # source is source, target is the target
    if target == "" or source == "":
        return None
    if len(target) > len(source):
        return None

    rolling_hash = RollingHash(source, len(target))
    target_hash = RollingHash(target, len(target))
    #target_hash.move_window()

    for i in range(len(source) - len(target) + 1):
        if rolling_hash.hash == target_hash.hash:
            if rolling_hash.window_source() == target:
                return i
        rolling_hash.move_window()
    return None
