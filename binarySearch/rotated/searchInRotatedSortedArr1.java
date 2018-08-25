public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            // situation 1: left is sorted
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            // situation 2: right is sorted
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
    //another version
    public int search(int[] nums, int target) {
        int left = 0;
        int right= nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(target==nums[mid])
                return mid;

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&& target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<target&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }
