# replace with longer or shorter
def replaceStr(input, source, target):
    if len(source) < len(target):
        return replace_longer(list(input), source, target)
    else:
        return replace_shorter(list(input), source, target)
# slow, fast
def replace_shorter(arr, source, target):
    slow = 0
    fast = 0
    while fast < len(arr):
        # need also consider space that does not inlucde source substring
        if fast <= len(arr) - len(source) and equalsubstr(arr, fast, source):
            replacestr(arr, slow, target)
            slow += len(target)
            fast += len(source)
        else:
            arr[slow] = arr[fast]
            slow += 1
            fast += 1
    return ''.join(arr[:slow])

def equalSubStr(arr, fast, source):
    temp = list(source)
    for index in range(len(source)):
        if arr[index + fast] != temp[index]:
            return False
    return True

def replacestr(arr, slow, target):
    temp = list(target)
    for index in range(len(target)):
        arr[index + slow] = temp[index]
# slow, fast, last_index
def replace_longer(arr, source, target):
    target_index_list = get_target_end_index(arr, target)
    writing_index = len(arr) + len(target_index) * (len(target) - len(source)) - 1  # writing index
    traverse_index = len(arr) - 1
    last_index = len(target_index_list) - 1

    while traverse_index >= 0:
        if(last_index >= 0 and traverse_index == target_index_list[last_index]):
            copySubStr(arr, writing_index - len(target) + 1, target)
            writing_index -= len(target)
            traverse_index -= len(source)
            last_index -= 1
        else:
            arr[writing_index] = arr[traverse_index]
            writing_index -= 1
            traverse_index -=1
    return ''.join(arr)

# record end index
def get_target_end_index(arr, source, target):
    res = []
    start_index = 0
    while start_index <= len(arr) - len(source):
        if equalSubStr(arr, start_index, source):
            res.append(start_index + len(source) - 1)   # record end index
            start_index += len(source)
        else:
            start_index += 1
    return res
