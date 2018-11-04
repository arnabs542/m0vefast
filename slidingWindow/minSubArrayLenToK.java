public int smallestSubWithSum(int[] arr, int k){
  int sum = 0;
  int n = arr.length;
  int min_len = Integer.MAX_VALUE;
  int j = 0;
  int i = 0;
  while(j<nums.length){
        if(sum < k){
            sum += nums[j++];
        }else{
            minLen = Math.min(minLen, j-1);
            sum -=nums[i++];
        }
        //end with j out of bound
    }

    while(sum >= k){
        min_len = Math.min(min_len, j-i);
        sum -= arr[i++];
    }
  return min_len;
}
