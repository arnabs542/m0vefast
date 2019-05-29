# apply rule to given array of string
# replace each 'a' by 'dd'    (replace longer helper)
# delete entry containing 'b'
def replace_remove(arr):
	size = len(arr)
	a_count = 0

	# forward iteration for removal
	write_index = 0
	for fast in range(size):
		if arr[fast] != 'b':
			arr[write_index] = arr[fast]
			write_index += 1
		if arr[fast] == 'a':
			a_count += 1

	# backward iteration for replacement with longer a -> dd
	cur_index = write_index - 1
	final_size = write_index + 1 + a_count
	write_index += a_count - 1
	while cur_index >= 0:
		if arr[cur_index] == 'a':
			arr[write_index - 1 : write_index + 1] = 'dd'
			write_index -= 2
		else:
			arr[write_index] = arr[cur_index]
			write_index -= 1
		cur_index -= 1

	return final_size
