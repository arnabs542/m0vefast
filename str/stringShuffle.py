# //a1a2a3 a4a5a6 -> a1a4 a2a5 a3a6
# //a1a2a3 a4a5a6 a7 -> a1a4 a2a5 a3a6 a7
# //merge sort
# https://app.laicode.io/app/problem/108


# 123|4567 | abc| defg
# 123|7654 | cba| defg
# 123|abc | 4567| defg
def stringShuffle(input):
    arr = list(input)
    if len(input) % 2 == 0:
        helper(arr, 0, len(arr) - 1)
    else:
        helper(arr, 0, len(arr) - 2)
    return ''.join(arr)

def helper(arr, left, right):
    size = right - left + 1
    if size <= 2:
        return
    mid = left + size // 2
    leftmid = left + size * 1 // 2
    righmid = left + size * 3 // 4

    reverse(arr, leftmid, mid-1)
    reverse(arr, mid, rightmid-1)
    reverse(arr, leftmid, rightmid-1)
    helper(arr, left, left + (leftmid - left) * 2 - 1)
    helper(arr, left + (leftmid - left) * 2, right)
