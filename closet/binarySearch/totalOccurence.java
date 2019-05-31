public int totalOccurrence(int[] arr, int target) {
        // Write your code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        int firstIndex = 0;
        int lastIndex = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        if (arr[start] == target) {
            firstIndex = start;
        }else if (arr[end] == target) {
            firstIndex = end;
        }else{
            return 0;
        }

        start = 0;
        end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if (arr[end] == target) {
            lastIndex = end;
        }else {
            lastIndex = start;
        }
        return lastIndex - firstIndex + 1;
    }
