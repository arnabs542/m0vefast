// Initialize sum = 0 and maxLen = 0.
// Create a hash table having (sum, index) tuples.
// For i = 0 to n-1, perform the following steps:
//       Accumulate arr[i] to sum.
//       If sum == k, update maxLen = i+1.
//       Check whether sum is present in the hash table or not. If not present, then add it to the hash table as (sum, i) pair.
//       Check if (sum-k) is present in the hash table or not. If present, then obtain index of (sum-k) from the hash table as index. Now check if maxLen < (i-index), then update maxLen = (i-index).
//       Return maxLen.
//O(n)
public int maxSubArrayLenToK(int[] arr, int k) {
    // Write your solution here
    //<sum, ENDING_index>
    Map<Integer, Integer> map = new HashMap<>();
    int max;
    int sum;
    int diff;
    for(int i = 0; i < arr.length; i++){
      sum += arr[i];
      if(sum == k){
        max = Math.max(max, i+1);
      }
      if(!map.containsKey(sum)){
          map.put(sum, i);
      }
      //ONLY for accumulative sum bigger than k
      diff = sum - k;
      if(map.containsKey(diff)){
          max = Math.max(max, i - map.get(diff));
      }
    }
    return max;
}
