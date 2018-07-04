//choices of 1 2 or 3
public int climbStairs2(int n){
	int[] f = new int[n+1];
	f[0] = 1;   //base case
	for(int i = 0; i <= n; i++){
		for(int j = 1; j<=3; j++){
			if(i >= j)
				f[i] += f[i-j];
		}
	}
	return f[n];
}

pubic int climbStairs2(int n){
	if(n <= 3)
		return n;

	int first = 1;
	int second = 2;
	int third = 3;
	int now = 0;
	for(int i = 4; i < n; i++){
		  now = first + second + third;
			first = second;
			second = third;
			thrid = now;
	}
	return now;

}
