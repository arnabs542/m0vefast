'''
arrayhopper1: can jump to the end?    # a[i] max advancement from i
arrayhopper2: min to jump to the end?
arrayhopper3: min to jump out of array?
arrayhopper4: left/right given start index, min to jump to the end?
'''


# greedy solution
# going forwrd
def canjump1(self, arr):
	# max_index: max index can reach so far
	max_index = 0
	for index, step in enumerate(arr):
		if index > max_index:
			return False
		max_index = max(max_index, index + step)

	return True

# going backwrds
def canjump1(self, arr):
	goal_index = len(arr) - 1
	for index in range(len(arr))[::-1]:  # from last index to the first index
		if index += arr[index] >= goal_index:
			goal_index = index # can reach current index, move left to check
	return not goal_index   # goal_indxex should be zero to be true
							# zero as false

# dp solution:
