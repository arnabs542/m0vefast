//choices of 1 2 or 3
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
