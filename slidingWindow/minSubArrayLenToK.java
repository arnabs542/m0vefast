//A simple sliding window solution.
// given nums are all positive integer, fine min lenth which the sum ≥ target
// left and right boundaries of the sliding window.
// When the sum is greater than the target, shift the left pointer;
// when the sum is less than the target, shift the right pointer
public int minSubArrayLen(int target, int[] nums) {
    if(nums==null||nums.length==0)
        return 0;
    int left = 0;
    int right = 0;
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    while(right < nums.length){
        if(sum < target){
            sum += nums[right];
            right++;
        }else{  //such subarr exist: sum >= target
            minLen = Math.min(minLen, right-left);
            if(left == right-1)
                return 1;
            sum -= nums[left];
            left++;
        }
    }
    //a[left1] + sum < target
    //a[left1] + a[left2] + sum < target
    //a[left1] + a[left2] + a[left3] + sum >= target
    //a[left2] + a[left3] + sum + a[right1] < target
    //a[left2] + a[left3] + sum + a[right1] + a[right2] < target
    //a[left2] + a[left3] + sum + a[right1] + a[right2] + a[right3] >= target
    //a[left3] + sum + a[right1] + a[right2] + a[right3] >= target  =>res = right3-left3
    //sum + a[right1] + a[right2] + a[right3] < target
    //this is useful for the last right number added is very big!, gotto minus lots of left compensate
    while(sum >= target){
        minLen = Math.min(minLen, right-left);
        sum -= nums[left++];
    }
    return minLen == Integer.MAX_VALUE? 0: minLen;
}
