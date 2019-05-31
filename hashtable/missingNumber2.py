# number from 1 - n, no duplicate, sorted, find the missing one
def missingNumber2(nums):
    # if empty
    if not nums:
        return 1
    # missing the last one
    left = 0
    right = len(nums) - 1

    if nums[right] == right + 1:
        return nums[right] + 1

    while left < right:
        mid = left + (right - left) // 2
        if nums[mid] > mid + 1:
            right = mid
        else:   # nums[mid] <= mid + 1
            left = mid + 1

    return nums[right] - 1
