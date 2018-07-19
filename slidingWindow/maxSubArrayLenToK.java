//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//Given nums = [-2, -1, 2, 1], k = 1,
//return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
// <-2,0><-3,1><-1,2><0,3>
// max=2 for -1,2
// max=2 for max(2, 3-2)
//O(n)
public int maxSubArrayLenToK(int[] arr, int k) {
    // Write your solution here
    //<sum, index>
    Map<Integer, Integer> map = new HashMap<>();
    int max;
    int sum;
    int diff;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(sum == k){
        max = Math.max(max, i+1);
      }
      diff = sum - k;
      if(map.containsKey(diff)){
          max = Math.max(max, i - map.get(diff));
      }
      if(!map.containsKey(sum)){
          map.put(sum, i);
      }
    }
    return max;
}
