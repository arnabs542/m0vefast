public int largestCross1s(int[][] matrix){
  int row = matrix.length;
  int col = matrix[0].length;
  if(row == 0 || col == 0){
    return 0;
  }
  //longest possible length for left and up arms ending at each cells in the matrix
  int[][] leftUp = leftUp(matrix, row, col);
  int[][] rightDown = rightDown(matrix, row, col);
  return merge(leftUp,rightDown, row, col);
}
//calculate the max length left and up arms for each cell in matrix
private int leftUp(int[][] matrix, int row, int col){
  int[][] left = new int[row][col];
  int[][] up = new int[row][col];
  int globalMax = 0;
  for(int i = 0; i < row; i++){
    for(int j = 0; j < col; j++){
      if(matrix[i][j] == 1){
        if(i == 0 && j == 0){
          left[i][j] = 1;
          up[i][j] = 1;
        }else if(i == 0){
          left[i][j] = left[i][j-1]+1;
          up[i][j] = 1;
        }else if(j == 0){
          left[i][j] = 1;
          up[i][j] = up[i-1][j];
        }else{
          left[i][j] = left[i][j-1]+1;
          up[i][j] = up[i-1][j]+1;
        }
      }
    }
  }
  merge(left, up, row, col);
  return left;
}
//calculate the max length left and up arms for each cell in matrix
private int rightDown(int[][] matrix, int row, int col){
  int[][] right = new int[row][col];
  int[][] down = new int[row][col];
  for(int i = row-1; i >= 0; i--){
    for(int j = col-1; j >= 0; j--){
      if(matrix[i][j] == 1){
        if(i == row-1 && j == col - 1){
          down[i][j] = 1;
          right[i][j] = 1;
        }else if(i == row-1){
          down[i][j] = 1;
          right[i][j] = right[i][j+1]+1;
        }else if(j == col - 1){
          down[i][j] = down[i+1][j]+1;
          right[i][j] = 1;
        }else{
          down[i][j] = down[i-1][j-1]+1;
          right[i][j] = right[i-1][j-1]+1;
        }
      }
    }
  }
  merge(right, down, row, col);
  return right;
}
private int merge(int[][] leftUp, int[][] rightDown, int row, int col){
  int globalMax = 0;
  for(int i = 0; i < row; i++){
    for(int j = 0; j < col; j++){
      leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
      globalMax = Math.max(globalMax, leftUp[i][j]);

    }
  }
  return globalMax;
}
