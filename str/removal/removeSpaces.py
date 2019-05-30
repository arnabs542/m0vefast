# Q0: remove duplicate white space
#" I   love TV" -> "I love TV"
def removeSpaces(input):
	if input is None or not input:
		return input

	arr = list(input)
	slow = 0
	for fast in range(len(arr)):
		# ignore head or consecutive ' '
		if arr[fast] == ' ' and (fast == 0 or arr[fast-1] == ' '):
			continue
		else:
			arr[slow] = arr[fast]
			slow += 1
	# remove tail ' '
	# if slow > 0 and arr[slow-1] == ' ':
	# 	slow = slow - 1
	# return ''.join(arr[:slow]
	return ''.join(arr[:slow-1 if slow > 0 and arr[slow - 1] == ' ' else slow])
