def searchRotatedSortedArr1(arr, target):
    if arr is None or not arr:
        return -1

    left, right = 0, len(arr)-1

    while left < right:
        mid = left + (right - leff)//2

        if arr[left] < arr[mid]:
            if arr[left] <= target and target <= arr[mid]:
                left = mid + 1
            else:
                right = mid - 1
        else:
            if arr[mid] <= target and target <= arr[right]:   # dont forgot the = sign!!!
                left = mid+1
            else:
                right = mid - 1

    if arr[left] == target:
        return left

    return -1
