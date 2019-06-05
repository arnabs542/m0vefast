//N*N matrix generatign using number 1,2,3,4...
//solution1: recursion
public int[][] spiralGenerate(int n) {
	int[][] matrix = new int[n][n];
	if(n == 0) 
		return matrix;
	helper(matrix, 0, n, 1);
	return matrix;
}
private void helper(int[][] matrix, int offset, int size, int num){
	//base case: only 0 or 1 element left
	if(size == 0)
		return;
	if(size == 1){
		matrix[offset][offset] = num;
		return;
	}
	for(int i = 0; i < size-1; i++)
		matrix[offset][offset+i] = num++;
	for(int i = 0; i < size-1; i++)
		matrix[offset+i][offset+size-1] = num++;
	for(int i = size-1; i >= 1; i--)
		matrix[offset+size-1][offset+i] = num++;
	for(int i = size-1; i >= 1; i--)
		matrix[offset+i][offset] = num++;
	helper(matrix, offset+1, size-2, num);
}
//solution2: iterative 
public int[][] spiralGenerate(int n) {
    int[][] matrix = new int[n][n];
    if(n == 0)
    	return matrix;
    int start = 0;
    int end = n-1;
    int num = 1;
    while(start < end){
    	for(int i = start; i <= end; i++){
    		matrix[start][i] = num++;
    	}
    	for(int i = start+1; i <= end-1; i++){
    		matrix[i][end] = num++;
    	}
    	for(int i = end; i <= start; i--){
    		matrix[end][i] = num++;
    	}
    	for(int i = end-1; i>= start+1; i--){
    		matrix[i][start] = num++;
    	}
    	start++;
    	end--;
    }
    //if at last we have 1 element left
    if(start == end)
    	matrix[start][end] = num++;
    return matrix;
}
















