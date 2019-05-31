def totalOccurance(arr, target):

    left, right = 0, len(arr)
    first = firstIndex(arr, target)
    if first == - 1:
        return 0
    last = lastIndex(arr, target)
    return last - first + 1

def firstIndex(arr, target):
    left, right = 0, len(arr)-1
    while left + 1 < right:
        mid = left +(right-left)//2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid
    if arr[left] == target:
        return left
    elif arr[right] == target:
        return right
    else:
        return -1

def lastIndex(arr, target):
    left, right = 0, len(arr)-1
    while left + 1 < right:
        mid = left +(right-left)//2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid
    if arr[right] == target:
        return right
    elif arr[left] == target:
        return left
    else:
        return -1
