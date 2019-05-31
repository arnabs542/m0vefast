# sliding window
def substringAnagram(source, target):
	res = []
	sum = [0] * 30
	t_len = len(target)
	s_len = len(source)
	for i in range(t_len):
		sum[ord(target[i] - ord['a'])] += 1
	left = 0
	right = 0
	matched = 0

	while right < s_len:
		if sum[ord(source[right] - ord(['a'])] >= 1:
			matched += 1
		sum[ord(s[right]) - ord['a']] -= 1
		right += 1

		if matched == t_len:
			res.append(left)

		if right - left == t_len:
			if sum[ord(source[right] - ord(['a'])] >= 0:
				matched -= 1
			sum[ord(s[left]) - ord['a']] += 1
			left += 1

	return res

def substringAnagram_map(long, short):
	res = []
	if len(long) == 0 or len(short) > len(long):
		return res
	match = 0

	dict = collections.Counter(short)
	for i in range(len(long)):
		# add right char
		if long[i] in dict:
			dict[long[i]] -= 1
			if dict[long[i]] == 0:
				match += 1
		# remove left char
		if i >= len(target):
			left_char = long[i - len(target)]
			if left_char in dict:
				dict[left_char] += 1
				if dict[left_char] == 1:
					match -= 1

		if match == len(dict):
			res.append(index - len(target) + 1)

	return res
