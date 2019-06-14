# 1. Reverse the entire string.
# 2. Reverse each word.
# 3. Deduplicate spaces.

# can not handle leading and tail white space
def reverseWords(self, s: str) -> str:
#         res = ' '.join(x[::-1] for x in s.split())
#         return ''.join(res[::-1])
        # return ' '.join(reversed(s.split()))
    def removeSpace(arr):
        cur = 0
        for i, item in enumerate(arr):
            if arr[i] == ' ' and (i == 0 or arr[i-1] == ' '):
                continue
            arr[cur] = arr[i]
            cur += 1
        return arr[0:cur-1] if cur > 0 and arr[cur-1] == ' ' else arr[0:cur]

    def reverse_range(arr, left, right):
        while left < right:
            arr[left],arr[right] = arr[right], arr[left]
            left += 1
            right -= 1

    arr = removeSpace(list(s))

    start = 0
    for i, item in enumerate(arr):
        if arr[i] != ' ' and (i == 0 or arr[i-1] == ' '):
            start = i
        if arr[i] != ' ' and (i==len(arr)-1 or arr[i+1] == ' '):
            reverse_range(arr, start, i)

    reverse_range(arr, 0, len(arr)-1)

    return ''.join(arr)

# follow up1:
'''
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
'''
    s[:] = ' '.join(reversed(''.join(s).split()))
