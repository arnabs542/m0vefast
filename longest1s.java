//basecase: dp[0] = arr[0
//indcution: dp[i]: the longest contiguous 1s(including ith element, since we need subarr, not subsequence)
dp[i] = dp[i-1] + 1    if dp[i] == 1
	  = 0            ow

public int longest(int[] arr){
	int global_max = 0;
	int cur = 0;
	for(int i = 0; i < arr.length; i++){
		if(arr[i] == 1){
			if(i == 0 || arr[i-1] == 0)
				cur = i;
			else
				cur++;
			global_max = Math.max(global_max, cur);
		}
	}
	return global_max;
}