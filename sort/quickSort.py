def quicksort(arr):
	if not arr:
		return
	helper(arr, 0, len(arr) - 1)

def helper(arr, left, right):
	if left >= right:
		return
	# find pivot
	pivot_index = partition(arr, left, right)
	helper(arr, left, pivot_index - 1)
	helper(arr, pivot_index + 1, right)

def partition(arr, left, right):
	pivot_index = right
	pivot = arr[pivot_index]
	swap(arr, pivot_index, right)
	i = left
	j = right
	while i <= j:
		if arr[i] < pivot:
			i += 1
		elif arr[j] >= pivot:
			j -= 1
		else:
			swap(arr, i, j--)
	swap(arr, i, right)
	return i
