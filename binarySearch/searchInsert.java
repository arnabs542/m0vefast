//first pos to insert: first index   [1,3,3,3,5,6], 3 → 1
public int searchInsert(int[] arr, int target) {
    // Write your solution here
    if (arr == null || arr.length == 0) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start] >= target) {
            return start;
        } else if (arr[end] >= target) {
            return end;
        } else {  //target not in arr, so
            return end + 1;
        }
    }
  }
