public int 3SumSmaller(int[] nums, int target) {
        // 先将数组排序
        Arrays.sort(nums);
        int res = 0;
        //search space for left component
        for(int i = 0; i < nums.length - 2; i++){
          //search space for right component
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                // 如果三个数的和大于等于目标数，那将尾指针向左移
                if(sum >= target){
                    right--;
                // 如果三个数的和小于目标数，那将头指针向右移
                } else {
                    // right - left个组合都是小于目标数的
                    res += right - left;
                    left++;
                }
            }
        }
        return res;
    }

https://segmentfault.com/a/1190000003794736
