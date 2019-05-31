def minRotatedSortedArr(arr):
    if arr is None or not arr:
        return -1

    left, right = 0, len(arr)-1

    while left + 1 < right:
        mid = left + (right - left)//2
        # duplicate
        if arr[mid] == arr[right]:
            right -= 1

        elif arr[mid] < arr[right]:
            right = mid

        elif arr[mid] > arr[right]:
            left = mid


    return min(arr[left], arr[right])


'''
 -
-
     -
    -
  - mid low

'''
-
    -
   -
  -
 -



    -
   -
  -
 -
      -
