public int smallerPairs(int[] array, int target) {
    // Write your solution here
    Arrays.sort(array);
    int count = 0;
    int left = 0, right = nums.length - 1;
    while(left < right){
        int sum = nums[left] + nums[right];
        // 如果三个数的和大于等于目标数，那将尾指针向左移
        if(sum >= target){
            right--;
        // 如果三个数的和小于目标数，那将头指针向右移
        } else {
            // right - left个组合都是小于目标数的
            count += right - left;
            left++;
        }
    }
    return count;
}
