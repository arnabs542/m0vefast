public int smallestSubWithSum(int arr[], int k){
  int sum = 0;
  int n = arr.length;
  int min_len = Integer.MAX_VALUE;
  int start = 0;
  int end = 0;
  while(end < n){
    while(sun <= k && end < n){
      // Ignore subarrays with negative sum if x is positive.
      // if (curr_sum <= 0 && x > 0){
      //     start = end;
      //     curr_sum = 0;
      // }
      sum += arr[end++];
    }
    while(sum > k && start < n){
      // Update minimum length if needed
      min_len = Math.min(min_len, end-start)
      // if (end - start < min_len)
      //     min_len = end - start;
      // remove starting elements
      sum -= arr[start++];
    }
  }
  return min_len;
}
