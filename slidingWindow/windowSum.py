def windonwSumOfK(arr, k):
	if arr is None or len(arr) < k:
		return [0]
	res = []
	for i in range(k):
		res[0] += arr[i]
	for i in range(1, len(arr) - k + 1):
		res[i] = res[i-1] - arr[i-1] + arr[i+k-1]
	return res
# there are len(arr) - k + 1 windows
