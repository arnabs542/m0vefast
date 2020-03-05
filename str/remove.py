# remove duplicate white space: "    I   love TV" -> "I love TV"
def remove_space(input):
	if input is None or not input:
		return input

	arr = list(input)
	slow = 0  # not lazy 
	for fast in range(len(arr)):
		# ignoring head or consecutive " "
		if arr[fast] == " " and (fast == 0 or arr[fast - 1] == " "):
			continue
		else:
			arr[slow] = arr[fast]
			slow += 1
	# remove tail " "
	if slow > 0 and arr[slow - 1] == " ":
		slow -= 1

	return "".join(arr[:slow])


# remove certain char: "abcdefg","af" -> "bcdeg"
def remove_certain_char(input, target):
	if input is None or not input:
		return input

	arr = list(input)
	target = set(target)

	slow = 0
	for fast in range(len(arr)):
		if arr[fast] not in target:
			arr[slow] = arr[fast]
			slow += 1

	return "".join(arr[:slow])



# check againg remove all substring(provided set) from source can produce the shortest length of the remaining string
# reduced s may appear before, no need to update min (dict might contain duplicate)
# aabcdd, (ab,cd,abcd)=>ab
# find the reduced string with min length 
# bfs, graph iwht childeren as input - each target, find global min
def remove_substr(input, target):
	import collections
	queue = []
	queue.append(input)
	visited = set()
	visited.add(input)
	min_len = len(input)

	while queue:
		cur = queue.pop()
		for each in target:
			found_index = cur.index(each)
			if found_index != -1:
				new_cur = cur[0, index] + cur[found+1, len(input)]
				min_len = min(min_len , len(new_cur))
				queue.append(new_cur)
				# found_index = cur.index(each, found_index + 1)

	return min_len

















