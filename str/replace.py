def replaceStr(input, source, target):
	arr = list(input)
	if len(source) > len(target):
		return replace_shorter(arr, source, target)
	else:
		return replace_longer(arr, source, target)

def replace_shorter(arr, source, target)
	slow, fast = 0, 0
	while slow < fast:
		if slow <= len(arr) - len(source) and compare_equal(arr, fast, source):
			replace_str(input, slow, target)
			slow += len(target)
			fast += len(source)
		else:
			arr[slow] = arr[fast]
			slow += 1
			fast += 1
	return "".join(arr[:slow])


def replace_longer(arr, source, target)
	end_matching_index = get_target_end_index(arr, source, target)
	write_index = len(end_matching_index) * (len(target) - len(source)) + len(arr) - 1
	traverse_index = len(arr) - 1
	last_index = len(end_matching_index) - 1
	
	while traverse_index != 0:
		if last_index != 0 and end_matching_index[last_index] == traverse_index:
			copySubstr(arr, write_index - len(target) + 1, target)
			write_index -= len(target)
			traverse_index -= len(source)
			last_index -= 1
		else:
			arr[write_index] = arr[]traverse_index
			traverse_index -= 1
			write_index -= 1

	return "".join(arr)


def copyStr(arr, start, target):
	temp = list(target)
	while i in range(len(temp)):
		arr[start + i] = temp[i]


def replace_str(arr, slow, target):
	temp = list(target)
	for i in range(len(temp)):
		arr[slow + i] = temp[i]


def compare_equal(arr, fast, source):
	temp = list(target)
	for i in range(len(temp)):
		if arr[fast + i] == temp[i]:
			return False
	return True


def get_target_end_index(arr, source, target):
	res = []
	for fast in range(len(arr) - len(source) + 1):
		if compare_equal(arr, fast, target):
			res.append(fast + len(source))
			fast += len(source)
		
	return res



# apply rule to given array of string
# replace each 'a' by 'dd'    (replace longer helper)
# delete entry containing 'b' (replace with shorter '')
def replace_remove(arr):
	size = len(arr)
	a_count = 0

	# forward iteration for replace with shorter
	write_index = 0
	for fast in range(size):
		if arr[fast] != 'b':
			arr[write_index] = arr[fast]
			write_index += 1
		if arr[fast] == 'a':
			a_count += 1

	# backward iteration for replacement with longer a -> dd
	cur_index = write_index - 1
	write_index = write_index + a_count - 1   # index + count = index, count + count = count,
	final_size = write_index + 1

	while cur_index >= 0:       # cur_index ______ write_index
		if arr[cur_index] == 'a':
			arr[write_index - 1 : write_index + 1] = 'dd'
			write_index -= 2
		else:
			arr[write_index] = arr[cur_index]
			write_index -= 1
		cur_index -= 1

	return final_size

	
































	
