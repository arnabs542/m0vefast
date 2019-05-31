# number from 0 - n, no duplicate, find the missing one
# solution1:
def missingNumber(nums):
	s = set(nums)
	for each in range(len(nums) + 1):
		if each not in s:
			return each
	return -1


# solution2:
def missingNumber(nums):
	sum = 0
	n = len(nums)
	for each in nums:
		sum += each

	return n * (n+1)//2 - sum




# number from 1 - n, no duplicate, find the missing one
def missingNumber(nums):
	s = set(nums)
	for each in range(1, len(nums) + 1):
		if each not in s:
			return each
	return -1
