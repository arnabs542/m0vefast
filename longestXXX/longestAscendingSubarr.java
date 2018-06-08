 //solution1: O(n^2*n) = O(n^3)
//there are n^2 subarr, for each subarr, need O(n) to determine whether it is a ascending subarr

//solution2: O(n), O(n)
public int longestAsendingSubArr(int[] arr){
	//corner case
	if(arr == null)
		return -1;
	if(arr.length == 0)
		return 0;
	//basecase: 不是arr没有内容,是不成立statement的结果
	//induction rule
	//dp[i] = 1 		when arr[i] <= arr[i-1] base case
	//      = dp[i-1]+1 when arr[i] > arr[i-1]
	int[] res = new int[n+1];
	int[0] = 1;
	for(int i = 1; i < arr.length; i++){
		if(arr[i] > arr[i-1])
			res[i] = res[i-1] + 1;
		else
			res[i] = 1;
	}
	return res[n];
}

//solution3, sliding window O(n), O(1)
public int longest(int[] arr){
	//corner case
	if(arr == null)
		return -1;
	if(arr.length == 0)
		return 0;
	//basecase: 不是arr没有内容,是不成立statement的结果
	int cur = 1;  //cur longest subarr including current index; right bound
	int global_max = 1;
	//induction rule:
	//dp[i] = 1 		when arr[i] <= arr[i-1]
	//	    = dp[i-1]+1 when ow
	for(int i = 1; i < arr.length; i++){
		if(arr[i] > arr[i-1]){
			cur++;
			global_max = Math.max(global_max, cur);
		}else{
			cur = 1;
		}
	}
	return global_max;
}
//solution4: sliding window O(n), O(1) with bound information
public int longest(int[] arr){
	//corner case
	if(arr == null)
		return -1;
	if(arr.length == 0)
		return 0;
	//basecase: 不是arr没有内容,是不成立statement的结果
	//induction rule:
	//dp[i] = 1 		when arr[i] <= arr[i-1]
	//	    = dp[i-1]+1 when ow
	int global_max = 1;
	int left = 0;  //left bound of subarr including cur index
	for(int i = 0; i < arr.length; i++){
		if(i == 0 || arr[i] > arr[i-1])
			global_max = Math.max(global_max, i - left + 1);
		else
			left = i;
	}
	return global_max;
}
