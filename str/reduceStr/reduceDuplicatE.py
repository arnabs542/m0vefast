# replace eeeee to e in a string
def removeDupliateE(input):
	if input is None or not input:
		return input
	arr = list(input)
	slow = 0
	for fast in range(1, len(arr)):
		if arr[fast] != 'e':
			slow += 1
			arr[slow] = arr[fast]
		else:
			slow += 1
			arr[slow] = arr[fast]
			while fast + 1 < len(arr) and arr[fast+1]=='e':
				fast += 1
