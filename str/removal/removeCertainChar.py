def removeCertainChar(input, target):
	arr = list(input)
	remove = set(target)

	slow = 0
	fast = 0
	for fast in range(len(arr)):
		if arr[fast] not in remove:
			arr[slow] = arr[fast]
			slow += 1
	return ''.join(arr[:slow])
