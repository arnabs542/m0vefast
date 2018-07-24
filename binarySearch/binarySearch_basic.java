//find first position of target: Find any position of a target number in a sorted array. Return -1 if target does not exist.
//e.g. Given [1, 2, 2, 4, 5, 5]. For target = 2, return 1 or 2. For target = 5, return 4 or 5. For target = 6, return -1.
public int findPosition(int[] nums, int target){
     if(nums == null || nums.length == 0){
          return -1;
     }

     int start = 0;
     int end = nums.length-1;
     while(start + 1 < end){
          int mid = start + (end - start)/2;
          if(nums[mid] == target){
               right = mid;
          }else if(nums[mid] < target){
               start = mid;
          }else{
               end = mid;
          }
     }

     if(nums[start] == target){
          return start;
     }
     if(nums[end] == target){
          return end;
     }
     return -1;
}

//find last position of target
public int lastPosition(int[] nums, int target){
     if(nums == null || nums.length == 0){
          return -1;
     }

     int start = 0;
     int end = nums.length-1;
     while(start + 1 < end){
          int mid = start+(end-start)/2;
          if(nums[mid] <= target){
               start = mid;
          }else{
               end = mid;
          }
     }
     if(nums[end] == target){
          return end;
     }
     if(nums[start] == target){
          return start;
     }
     return -1;
}
//first target

//last target


public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
