# more space
def isAnagram(shorter, longer):
	from collections import Counter

	d1 = Counter(shorter)
	d2 = Coutner(longer[:len(shorter)])
	for right in range(len(shorter), len(longer)):
		if d1 == d2:
			return True

		d2[longer[right]] += 1
		d2[longer[right - len(shorter)]] -= 1
		if d2[longer[right - len(shorter)]] == 0:
			del d2[longer[right - len(shorter)]]

	return d1 == d2


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

