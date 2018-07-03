public int largestSquareSurounded1s(int[][] matrix) {
    // return square length
    int row = matrix.length;
    int col = matrix[0].length;
    if(row == 0 || col == 0)
      return 0;
    int globalMax = 0;
    //only need 2 direction
    int[][] right = new int[row+1][col+1];  //left to right
    int[][] bottom = new int[row+1][col+1];  //top to bottom
    //right[i][j] is mapped to matrix[i-1][j-1] to reduce corner case
    for(int i = 0; i < row; i++){
    	for(int j = 0; j < col; j++){
      	if(matrix[i][j] == 1){
        	right[i+1][j+1] = right[i+1][j] + 1;
          bottom[i+1][j+1] = bottom[i][j+1] + 1;
        }
        //maxi length of surrounded by 1 matrix with rightbottom position at matrix[i][j]
        //is determined by the min of right[i+1][j+1] and bottom[i+1][j+1] (need a square)
        //check one by one all possible lengths if it can provide the actual matrix
        //only need to check the longest left arm length of the righttop cell and
        //                   the longest up arm length of the leftbottom cell
        for(int max_len = Math.min(right[i+1][j+1], bottom[i+1][j+1]);
            max_len >= 1;
            max_len--){
        	if(right[i + 1 - max_len + 1][j+1] >= max_len && bottom[i+1][j+1-max_len+1] >= max_len){
          	globalMax = Math.max(globalMax, max_len);
            break;
          }
        }
    	}
  	}
    return globalMax;
	}
