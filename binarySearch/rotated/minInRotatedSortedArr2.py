def minRotatedSortedArr1(self, arr: List[int]) -> int:
    if arr is None or not arr:
        return -1

    left, right = 0, len(arr) - 1

    while left < right:
        mid = left + (right - left) // 2
        if arr[mid] <= arr[right]:
            right = mid
        else:
            left = mid + 1

    return arr[left]


 
