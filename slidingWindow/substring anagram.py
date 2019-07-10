def substringAnagram(source, target):
    if source is None or target is None or len(target) > len(source):
        return []

    dict = collections.Counter(target)
    left = 0
    right = 0
    match = 0
    res = ""
    minLength = len(source)
    for i in range(len(source)):  # for each left bound
        while right < len(source):   # check right boud
            if source[right] in dict:
                dict[source[right]]-=1
                if dict[source[right]] == 0:
                    match += 1
            if match == len(target) and right - left + 1 < minLength:
                minLength = right - left + 1
                res = source[left:right+1]
                break
            right += 1

        if source[left] in dict:
            dict[char] += 1
            if dict[char] == 1:
                match -= 1

    return res


def substringAnagram_map(long, short):
	res = []
	if len(long) == 0 or len(short) > len(long):
		return res
	match = 0

	dict = collections.Counter(short)
	for i in range(len(long)):    # each index of long
		# add right char
		if long[i] in dict:
			dict[long[i]] -= 1
			if dict[long[i]] == 0:
				match += 1
		# remove left char
		if i >= len(target):    # >=   i is already in the next window
			left_char = long[i - len(target)]
			if left_char in dict:
				dict[left_char] += 1
				if dict[left_char] == 1:
					match -= 1

		if match == len(dict):   # evluate size of dict not len of target
			res.append(i - len(target) + 1)   # left index of the window

		i += 1

	return res
