#inplace, time: n
def moveZero(arr):
	count = arr.count(0)
	arr[:] = [each for each in arr if each != 0]
	arr += [0] * count

# arr[:] return shallow copy of the original list

# del arr # Deletes the array itself
# del arr[:]  # Deletes all the elements in the array