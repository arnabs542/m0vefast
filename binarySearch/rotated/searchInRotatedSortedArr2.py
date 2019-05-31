def searchRotatedSortedArr2(arr, target):
    # with duplicate
    if arr is None or not arr:
        return -1

    left, right = 0, len(arr)-1
    while left + 1 < right:
        mid = left + (right- left)//2

        if arr[mid]== target:
            return mid
        elif arr[left] == arr[mid]:
            left += 1   # wrong: left = mid   13111 target 3
        elif arr[left] < arr[mid]:
            if arr[left] <= target and target <= arr[mid]:
                right = mid
            else:
                left = mid
        else:
            if arr[mid] <= target and target <= arr[right]:
                left = mid
            else:
                right = mid

    if arr[left] == target or arr[right] == target:
        return left
    return -1
