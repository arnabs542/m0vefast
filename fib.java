//recursion, timeout O(2^n), O(n) from call stack recording cur level info
public long fib(int n){
	if(n <= 0)
		return 0;
	if(n == 1)
		return 1;
	return fib(n-1)+fib(n-2);
}

//iteration + dp, O(n) space for arr
public long fib(int n){
	if(n <= 0)
		return 0;
	long[] arr = new long[n+1];  
	//arr[0]=1     basecase
	arr[1] = 1;   //basecase
	//i = 2 for arr[i-2]
	for(int i = 2; i <= n; i++)
		arr[i] = arr[i-1]+arr[i-2];
	return arr[n];
}

//dp + memorization, O(1) space 
public long fib(int n){
	long a = 0;
	long b = 1;
	if(n <= 0)
		return a;
	while(n > 1){
		long temp = a+b;
		a = b;
		b = temp;
		n--;
	}
	return b;
}

//matrix multiplication: O(lgn)
public long fib(int n){
	if(n <= 0)
		return 0;
	if(n == 1)
		return n;
	long[][] matrix = {{1L, 1L},{1L. 0L}};
	pow(matrix, n-1);
	return matrix[0][0];
}
private void multiplication(long[][] matrix, int pow){
	if(pow == 1)
		return;
	multiplication(matrix, matrix);
	if(pow % 2 != 0)
		multiplication(matrix, SEED);
}

private void multiplication(long[][] a, long[][] b){
	long topLeft = a[0][0] * b[0][0] + a[0][1] * b[1][0];
	long topRight = a[0][0] * b[0][1] + a[0][1] * b[1][1];
	long topLeft = a[1][0] * b[0][0] + a[0][1] * b[1][0];
	long topRight = a[1][0] * b[0][1] + a[1][1] * b[1][1];
	a[1][1] = topLeft;
	a[0][1] = topRight;
	a[1][0] = bottomLeft;
	a[1][1] = bottomRight;
}







