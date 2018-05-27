public int largestSurounded1s(int[][] matrix) {
    // Write your solution here
    int row = matrix.length;
    int col = matrix[0].length;
    if(row == 0 || col == 0)
      return 0;
    int globalMax = 0;
    int[][] right = new int[row+1][col+1];  //left to right
    int[][] bottom = new int[row+1][col+1];  //top to bottom
    for(int i = 0; i < row; i++){
    	for(int j = 0; j < col; j++){
      	if(matrix[i][j] == 1){
        	right[i+1][j+1] = right[i+1][j] + 1;
          bottom[i+1][j+1] = bottom[i][j+1] + 1;
        }
        for(int max_len = Math.min(right[i+1][j+1], bottom[i+1][j+1]);
            max_len >= 1;
            max_len--){
        	if(right[i + 1 - max_len + 1][j+1] >= max_len
             && bottom[i+1][j+1-max_len+1] >= max_len){
          	globalMax = Math.max(globalMax, max_len);
            break;
          }
        }
    	}
  	}
    return globalMax;
	}
