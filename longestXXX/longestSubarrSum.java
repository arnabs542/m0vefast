//O(n) O(1)
//basecase: dp[0] = arr[0];
//induction: dp[i] = max(dp[i-1]+arr[i], arr[i])
//                 = dp[i-1]+arr[i]   when dp[i-1] >= 0
//				   = arr[i]           ow			   

public int largestSum(int[] arr){
	int glbalMax = arr[0];
	int cur = arr[0];  //largest subarr including arr[i]
	for(int i = 1; i < arr.length; i++){
		cur = Math.max(cur + arr[i], arr[i]);
		globalMax = Math.max(globalMax, cur);
	}
	return globalMax;
}

//FOLLOW-UP: how to track the left and right bound

