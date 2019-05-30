# //“a1c0b2c4” → “abbcccc” 2
# //char number char number...
# //“acb2c4” → “acbbcccc” 1
# //char char char number....
def decode2(input):
    slow = 0
    fast = 0
    res = []
    count = 0
    while fast < len(arr):
        if arr[fast].isDigit():
            count = count * 10 + ord(arr[fast]) - ord('0')
        else:
            res.append(text * count)
            count = 0
            text = arr[fast]
    if arr[-1].

    return ''.join(arr)
