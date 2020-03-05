def duplicate_1(str):
	if str is None or not str:
		return str

	arr = list(str)
	slow = 0
	for fast in range(1, len(arr)):
		if arr[slow] != arr[fast]:
			slow += 1
			arr[slow] = arr[fast]
	
	return "".join(arr[:slow+1])


# Input: "bcabc"
# Output: "abc"
# TODO:
def duplicate_1_1(str):

def duplicate_2(str):
	if str is None or not str:
		return str

	arr = list(str)
	slow = 0
	counter = 0

	for fast in range(1, len(arr)):
		if arr[slow] == arr[fast]:
			if counter < 2:
				counter += 1
				slow += 1
				arr[slow] = arr[fast]
		else:
			slow += 1
			arr[slow] = arr[fast]
			counter = 1

	return "".join(arr[:slow+1])


def duplciate_0(str):
	if str is None or not str:
		return str

	arr = list(str)
	isSeen = False
	slow = 0

	for fast in range(1, len(arr)):
		if arr[fast] == arr[slow]:
			isSeen = True
		elif isSeen:
			arr[slow] = arr[fast]
			isSeen = False
		else:
			slow += 1
			arr[slow] = arr[fast]

	return "".join(arr[:slow] if isSeen else arr[:slow+1])


def duplicate_zuma(str):
	if str is None or not str:
		return str

	arr = list(str)
	slow = 0

	for fast in range(1, len(arr)):
		if slow == -1 or arr[slow] != arr[fast]:
			slow += 1
			arr[slow] = arr[fast]

		else:
			while fast + 1 < len(arr) and arr[fast] == arr[fast + 1]:
				fast += 1
			slow -= 1

	return "".join(arr[:slow+1])



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



	

