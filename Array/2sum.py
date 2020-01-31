# n, n
def 2_sum(arr, target):
	visited = set()
	for each in arr:
		if target - each in visited:
			return True
	return False

# 2 pointers: nlgn, 1 
def 2_sum(arr, target):
	arr.sort() # nlgn
	left = 0
	right = len(arr) - 1
	while left < right:
		cur_sum = arr[left] + arr[right]
		if cur_sum == target:
			return True
		elif cur_sum < target:
			left += 1
		else:
			right -= 1
	return False

# nlgn.  ????????
# return all tuples 
# not sorted, i, i+1, right
# 
def 3_sum(arr, target):
	res = []
	arr.sort() #nlgn
	for i in range(len(arr) - 2):  #n*n?
		if i > 0 and arr[i] == arr[i-1]:
			continue
		left = i + 1
		right = len(arr) - 1
		while left < right:  
			cur_sum = arr[left] + arr[right]
			if cur_sum + arr[i] == target
				res.append([arr[i], arr[left], arr[right]])
				left += 1
			elif cur_sum + arr[i] < target:
				left += 1
			else:
				right -= 1
	return res

#################################################
# n, n
def 2_sum_2arr(arr1, arr2, target):
	visited = set(arr1)
	for each in arr2:
		if (target - each) in visited:
			return True
	return False

# n^2 n
def 3_sum_3arr(arr1, arr2, arr3, target):
	visited = set(arr1)
	for i in range(len(arr2) - 1):
		for j in range(len(arr3) - 1):
			if target - arr1[i] - arr2[j] in visited:
				return True
	return False



#################################################
# Return the difference between the sum of the two integers and the target.
# return 2 numbers
# n
def 2_sum_cloest(arr, target):
	left = 0
	right = len(arr) - 1
	res = []
	min_diff = 1e9
	while left < right:
		cur_sum = arr[left] + arr[right]
		diff = Math.abs(target - cur_sum)
		if diff == 0:
			res = [arr[left], arr[right]]
		elif diff < min_diff:
			min_diff = diff
			res = [arr[left], arr[right]]

		if cur_sum > target:
			right -= 1
		else:
			left += 1

	return res


def 3_sum_cloest(arr, target):
	arr.sort()
	res = []
	min_diff = 1e9
	for i in range(len(arr) - 1):
		if i > 0 and arr[i] == arr[i-1]:
			continue
		left = i+1
		right = len(arr) - 1
		while left < right:
			cur_sum = arr[left] + arr[right]
			diff = Math.abs(target - cur_sum - arr[i])
			if diff == 0:
				res = [arr[i], arr[left], arr[right]]
			elif diff < min_diff:
				diff = min_diff
				res = [arr[i], arr[left], arr[right]]
			
			if cur_sum > diff:
				right -= 1
			else:
				left += 1
	return res



#################################################
# dict{each, each_indexs}
def 2_sum_index_pair(arr, target):
	res = []
	mapping = {}
	for i in range(len(arr)):
		if target - arr[i] in mapping:  # has a pair with arr[i]
			indexs = mapping.get(target-arr[i]) 
			for j in index: # j is the small index
				res.append([j, i])
		else:
			mapping[arr[i]] = []
		mapping.get(arr[i]).add(i)
	return res

def 2_sum_value_pair(arr, target):
	res = []
	mapping = {}
	for i in range(len(arr)):
		if target - arr[i] in mapping:  # has a pair with arr[i]
			indexs = mapping.get(target-arr[i]) 
			for j in index: # j is the small index
				res.append([arr[j], arr[i]])
		else:
			mapping[arr[i]] = []
		mapping.get(arr[i]).add(i)
	return res

# nlgn
def 3_sum_value_pair(arr, target):
	res = []
	arr.sort()
	for i in range(len(arr) - 1):
		if i > 0 and arr[i] == arr[i-1]:
			continue
		left = i + 1
		right = len(arr) - 1
		while left < right:
			cur_sum = arr[left] + arr[right]
			if target - cur_sum == arr[i]:
				res.add([i, left, right])
				left += 1
			elif target - cur_sum < 0:
				right -= 1
			else:
				left += 1
	return res

# TODO
def 2_sum_smaller(arr, target):

# TODO
def 3_sum_smaller(arr, target):


def 4_sum(arr, target):


# //solution1: O(n^3)
# //assuming arr.length >=4
# public boolean exist(int[] arr, int target){
# 	Arrays.sort(arr);
# 	for(int i = 0; i < arr.length - 3; i++){
# 		for(int j = i+1; j < arr.length-2; j++){
# 			int left = j+1;
# 			int right = arr.length-1;
# 			int curTarget = target - arr[i] - arr[j];
# 			//notice! dont go ouside left and right bound
# 			while(left < right){
# 				int sum = arr[left] + arr[right];
# 				if(sum == curTarget)
# 					return true;
# 				else if(sum < curTarget)
# 					left++;
# 				else
# 					right--;
# 			}
# 		}
# 	}
# 	return false;
# }

# //solution2: O(n^2*lgn), get all paris of numebrs and apply 2 sum







