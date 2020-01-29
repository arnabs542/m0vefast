# save 1
def dedup1(arr):
	if arr = []:
		return arr
	slow = 0 		# lazy
	for fast in range(1, len(arr) - 1):
		if arr[slow] != arr[fast]:
			slow += 1
			arr[slow] = arr[fast]
	return arr[:slow + 1]

# save 2
def dedup2(arr):
	if arr = []:
		return arr
	counter = 0
	slow = 0  # lazy
	for fast in range(1, len(arr) - 1):
		if arr[slow] == arr[fast]:
			if counter < 2
				slow += 1
				arr[slow] = arr[fast]
				counter += 1
		else:
			slow += 1
			arr[slow] = arr[fast]
			counter = 0

	return arr[:slow + 1]


# save 0
def dedup0(arr):
	if arr = []:
		return arr
	slow = 0  # lazy
	hasSeen = False
	for fast in range(len(arr) - 1):
		if arr[slow] == arr[fast]:  # same
			hasSeen = True
		elif hasSeen:				# different 
			arr[slow] = arr[fast]
			hasSeen = False
		else:						# different 
			slow += 1
			arr[slow] = arr[fast]

	return arr[:slow] if hasSeen else arr[:slow+1]

# zuma
def zuma(arr):
	if not arr or arr = []:
		return arr

	slow = 0  # stack top
	fast = 0
	while fast < len(arr):
		fast += 1
		if slow == -1 or arr[slow] != arr[fast]:
			slow += 1
			arr[slow] = arr[fast]
		else:
			while fast + 1 < len(arr) and arr[fast+1] == arr[slow]:
				fast += 1
			slow -= 1

	return arr[:slow+1]











