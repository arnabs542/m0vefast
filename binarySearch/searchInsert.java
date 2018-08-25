//search  Insert Position >= target
public int searrrchInsert(int[] arr, int target) {
    // Write your solution here
    if (arr == null || arr.length == 0) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[start] >= target) {
            return start;
        } else if (arr[end] >= target) {
            return end;
        } else {  //target greater than arr[end]
            return end + 1;
        }
    }
  }
