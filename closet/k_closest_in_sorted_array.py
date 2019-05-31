def kCloestInSortedArr(arr, k, target):
	'''
	Algorithm:
        1. Find the first index that A[index] >= target
        2. Set two pointers left = index - 1 and right = index
        3. Compare A[left] and A[right] to decide which pointer should move
		'''

	if len(arr) < k:
		return []

	right = findFirstIndex(arr, target)
	left = right -1
	res = []
	for i in range(k):
		if left < 0:
			res.append(arr[right])
			right += 1
		elif right >= len(arr):
			res.append(arr[left])
			left -= 1
		else:
			if abs(arr[left] - target) <= abs(arr[right] - target):
				res.append(arr[left])
				left -= 1
			else:
				res.append(arr[right])
				right += 1

	return res

def findFirstIndex(arr, target):
	left, right = 0, len(arr) - 1
	while left + 1 < right:
		mid = left + (right - left) //2
		if arr[mid] == target:
			return mid
		elif arr[mid] < target:
			left = mid
		else:
			right = mid

	'''
	array has one element: return it
	array has two elements: check
	solution has two element, on the left
	solution has two element, on the left
	target not exist, return right
	'''
	if arr[left] >= target:
		return left
	return right


if __name__ == '__main__':
	arr = [1, 4, 8, 12, 16, 28, 38]
	target = 1
	k = 4
	kCloestInSortedArr(arr, k, target)
