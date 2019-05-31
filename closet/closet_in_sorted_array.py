def closestInSortedArr(arr, target):
	if arr is None or not arr:
		return -1

	left, right = bianrySearch(arr, target)
	return left if abs(arr[left] - target) > abs(arr[right] - target) else right


def bianrySearch(arr, target):
	left, right = 0, len(arr)-1
	while left + 1 < right:
		mid = left + (right - left )//2
		if arr[mid] == target:
			return mid
		elif arr[mid] < target:
			left = mid
		else:
			right = mid
	return left, right
