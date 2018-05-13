//A = {3, 4, 5, 1, 2}, T = 4, return 1
//with duplicate element
public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[mid] > nums[left]) {
                if (nums[mid] >= target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public boolean search(int[] A, int target) {
            for (int i = 0; i < A.length; i ++) {
                if (A[i] == target) {
                    return true;
                }
            }
            return false;
        }
