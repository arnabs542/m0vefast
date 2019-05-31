# general
def binarySearch(arr, target):
    left, right = 0, len(arr) - 1
    while left + 1 < right:
        mid = left + (right - left )// 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid
        else:
            right = mid
    if arr[left] == target:
        return left
    elif arr[right] == target:
        return right
    else:
        return -1

def binarySearch(arr, target):
    left, right = 0, len(arr) - 1
    while left < right:
        mid = left + (right-left)//2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left + mid+1
        else:
            right = mid - 1
    if arr[left] == target:
        return left
    else:
        return -1

# first index
def binarySearch(arr, target):
    left, right = 0, len(arr) - 1
    while left + 1 < right:
        mid = left + (right - left)//2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid
    '''
    1) array has one element
    2) array has two element
    3) solution between 2, on left
    4) solution between 2, on right
    5) solution not exist
    '''
    if arr[left] == target:
        return left
    elif arr[right] == target:
        return right
    else:
        return -1
# last index
def binarySearch(arr, target):
