//solution1: recursion O(n^n)
public int getMaxProduct(int n){
	//basecase
	if(n <= 1)
		return 0;
	int global_max = 0; 
	for(int i = 1; i < n; i++)  //i: meters of rope to cut off
		int best = Math.max(n-i, getMaxProduct(n-i));
						 //(no cut)rope maintain, cut == subproblem
		global_max = Math.max(global_max, i*best);
	}
	return global_max;
}
//solution2: dp1 O(n^2) 左大段 右大段
public int maxProduct(int length){
	int[] arr = new int[length+1];
	//basecase: dp[1] = 0;  length = 1, product = 0;
	arr[0] = 0;
	arr[1] = 0;
	//induction:
	//dp[i] = max(i, dp[i])
	for(int i = 1; i <= length; i++){
		int global_max = 0;
		for(int j = 1; j <= i/2; j++){
											  //left              * right
			global_max = Math.max(global_max, Math.max(j, arr[j]) * Math.max(i-j, arr[i-j]));
		}
		arr[i] = global_max;
	}
	return arr[n];
}

//solution3: dp2 左大段 右大段
public int maxProduct(int length){
	//basecase
	if(length <= 1)
		return 0;
	if(length == 2)
		return 1;
	//induction rule
	//dp[i] = maxProduct of that size 
	int arr = new int[length+1];
	//arr[1] = 0;
	arr[2] = 1;
	for(int i = 3; i < arr.length; i++){
		//at least one of the partition is <= i/2
		for(int j = 1; j <= i/2; j++){
			//we have choice: not cut(arr[i]) and cut: 
												//RHS_length: max(not_not: i-j and cut(arr[i-j])
												//LHS_length: j
			arr[i] = Math.max(arr[i], j * Math.max(i - j, arr[i-j]));
		}
	}
	return arr[length];
}
