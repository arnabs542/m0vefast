#inplace, time: n
def moveZero(arr):
	count = arr.count(0)
	arr[:] = [each for each in arr if each != 0]
	arr += [0] * count
