public int climbStairs(int n){
	if(n <= 1)
		return n;
	int last = 1,
	int lastlast = 1;
	int now = 0;
	for(int i = 2; i <= n; i++){
		now = last + lastlast;
		lastlast = last;
		last = now;
	}
	return now;
}

public int climbStairs2(int n){
	int[] f = new int[n+1];
	f[0] = 1;
	for(int i = 0; i <= n; i++){
		for(int j = 1; j<=3; j++){
			if(i >= j)
				f[i] += f[i-j];
		}
	}
	return f[n];
}