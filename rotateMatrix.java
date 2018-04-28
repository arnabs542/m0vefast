
//solution2: rotate a point by 90 degree clockwise ==
//1) mirror the point according to y axis, then
//2) mirror the point according the line of y = x
public void rotate(int[][] matrix){
	int n = matrix.length;
	if(n <= 1)
		return;
	mirrorY(matrix, n);
	mirrorYX(matrix, n);
}
private void mirrorY(int[][] matrix, int n){
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n/2; j++){
			swap(matrix, i, j, i, n-1-j);
		}
	}
}
private void mirrorYX(int[][] matrix, int n){
	for(int i = 0; i < n; i++){
		// for j to n-1!!!!!
		for(int j = 0; j + i < n-1; j++){
			swap(matrix, i, j, n-1-j, n-1-i);
		}
	}
}
private void swap(int[][] matrix, int irow, int icol, int jrow, int jcol){
	int temp = matrix[irow][icol];
	matrix[irow][jcol] = matrix[jrow][jcol];
	matrix[jrow][jcol] = temp;
}

//solution1: split into levels and for each level, split into 4 partitions
//??????????????????????
public void rotate(int[][] matrix){
	int n = matrix.length;
	if(n <= 1)
		return;
	int round = n/2;
	for(int level = 0; level < round; level++){
		int left = level;
		int right = n - 2 - level;
		for(int i = left; i <= right; i++){
			int temp = matrix[left][i];
			matrix[left][i] = matrix[n-1-i][i];
			matrix[n-1-i][left] = matrix[n-1-left][n-1-i];
			matrix[n-1-left][n-1-i] = matrix[i][n-1-i];
			matrix[i][n-1-left] = temp;
		}
	}
}
