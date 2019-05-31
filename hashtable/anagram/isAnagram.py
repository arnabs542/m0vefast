# more time, sort
def isAnagram(a, b):
	aa = [i for i in a]
	bb = [i for i in b]
	aa.sort()
	bb.sort()
	return ''.join(aa) == ''.join(bb)
# use hashtable or []
def isAnagram(a, b):
	if len(a) != len(b):
		return False
	count = [0]*256
	for a_i in a:
		count[ord(a[a_i]) - ord('0')] += 1
	for b_i in b:
		count[ord(b[b_i]) - ord('0')] -= 1
		if count[ord(b[b_i]) - ord('0')] < 0:
			return False
	return True
