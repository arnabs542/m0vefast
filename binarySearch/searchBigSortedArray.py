def searchBigSortedArray(reader, target):
	right = 1
	while read.get[right-1] is not None and read.get(i-1) < target:
		right = right * 2
	right = right -1
	left = right -2
	while left + 1 < right:
		mid = left + (right - left) //2
		if reader.get(mid) >= target:
			right = mid
		else:
			left = mid

	if reader.get(left) == target:
		return left
	elif reader.get(right) == target:
		return right
	else:
		return -1
