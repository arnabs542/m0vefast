//choises of 1 and 2, return how many differen ways to climb
//dp + memorization
public int climbStairs(int n){
	if(n <= 1)
		return n;
	int last = 1;
	int lastlast = 1;
	int now = 0;
	//lastlast, last, now
	for(int i = 2; i <= n; i++){
		now = last + lastlast;
		lastlast = last;
		last = now;
	}
	return now;
}

//worse version with more space
public int climbStairs(int n) {
			 if (n <= 1) return 1;
			 int[] dp = new int[n];
			 dp[0] = 1; dp[1] = 2;
			 for (int i = 2; i < n; ++i) {
					 dp[i] = dp[i - 1] + dp[i - 2];
			 }
			 return dp[n - 1];
	 }
