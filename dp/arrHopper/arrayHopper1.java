arrayhopper1: can jump to the end?    # a[i] max advancement from i
arrayhopper2: min to jump to the end?
arrayhopper3: min to jump out of array?
arrayhopper4: left/right given start index, min to jump to the end?

//Determine if you are able to reach the last index.
//solution1: dp, arr[i] = from index 0 can jump to index i
public boolean canJump(int[] array){
	boolean[] dp = new boolean[array.length];
	dp[0] = true;
	for(int i = 1; i < array.length; i++){
		for(int j = 0; j < i; j++){
			//if j is reachable from 0, and from j it is possibel to jump to i
			if(dp[j] && array[j] + j >= i){
				dp[i] = true;
				break;
			}
		}
	}
	return dp[array.length-1];
}
{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
{2, 1, 1, 0, 2}, we are not able to reach the end of array
//solution2: dp, arr[i] = from index i can jump to last element/target
public boolean canJump(int[] arr){
	//basecase
	if(arr.length == 1)
		return true;
	boolean[] arr = new boolean[arr.length];
	//induction rule
	for(int i = arr.length-2; i >= 0; i--){
		if(i + arr[i] >= arr.length-1)
			arr[i] = true;
		else{
			for(int j = arr[i]; j >= 1; j--){
				if(arr[j+i]){
					arr[i] = true;
					break;
				}
			}
		}
	}
	return arr[0];
}
//solution3: greedy
