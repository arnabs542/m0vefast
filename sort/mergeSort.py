def mergesort(arr):
	if not arr or len(arr) <= 1:
		return
	mid = len(arr)//2  # interger devision   / return double
	left_half = arr[:mid]
	right_half = arr[mid:]
	mergesort(left_half)
	mergesort(right_half)

	# sort
	i = 0
	j = 0
	index = 0  # as a global variable
	while i < len(left_half) and j < len(right_half):
		if left_half[i] < right_half[j]:
			arr[index] = left_half[i]
			i += 1
		else:
			arr[index] = right_half[j]
			j += 1
		index += 1

	while(i < len(left_half)):
		arr[index] = left_half[i]
		i += 1
		index += 1

	while(j < len(right_half)):
		arr[index] = right_half[j]
		j += 1
		index += 1
