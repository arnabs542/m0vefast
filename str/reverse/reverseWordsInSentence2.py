#'   i love     google' -> 'i love google'
def ilovegoogle3000(input):
    if input is None or not input:
        return input

    removeSpace(input)

    # step1: reverse entire
    input = input.reverse()
    # step2: reverse each
    start = 0
    while True:
        end = input.find(' ', start)
        if end < 0:
            break
        reverse_range(input, start, end-1)
        start = end + 1
    # reverse last one
    reverse_range(input, start, len(input) - 1)
    return input

def reverse_range(input, left, right):
    arr = list(input)
    while left < right:
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1
    return ''.join(arr)

def removeSpace(input):
    arr = list(input)
    slow = 0
    fast = 0
    while fast < len(arr):
        # heading and middle ' '
        if arr[fast] == ' ' and (fast == 0 or arr[fast-1] == arr[fast]):
            fast += 1
        else:
            arr[slow] = arr[fast]
            slow += 1
            fast += 1
    # tail ' '
    if slow > 0 and arr[slow - 1] == ' ':
        return ''.join(arr[:slow - 1])
    return ''.join(arr[:slow])
