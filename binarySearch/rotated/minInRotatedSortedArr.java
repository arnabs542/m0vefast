public int findMin(int[] nums){
    if(nums == null || nums.length == 0)
        return -1;
    int start = 0;
    int end = nums.length-1;
    int target = nums[nums.length-1];

    // find the first element(from left) that <= target
    // compare mid element and last element
    while(start + 1 < end){
        int mid = start + (end - start)/2;
        //right side is sorted, check left side
        if(nums[mid] <= target)
            end = mid;
        //left side is sorted, check right side
        else 
            start = mid;
    }
    //left+1=right:
    //arr[mid]=arr[left],
    //min=min(arr[mid],arr[right])
    if(nums[start] <= target)
        return nums[start];
    return nums[end];
}
