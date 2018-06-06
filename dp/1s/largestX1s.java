public int largestX1s(int[][] matrix){
  int row = matrix.length;
  int col = matrix[0].length;
  if(row == 0 || col == 0){
    return 0;
  }
  int[][] leftUp = leftUp(matrix, row, col);
  int[][] rightDown = rightDown(matrix, row, col);
  return merge(leftUp,rightDown, row, col);
}
private int leftUp(int[][] matrix, int row, int col){
  int[][] left = new int[row][col];
  int[][] up = new int[row][col];
  for(int i = 0; i < row; i++){
    for(int j = 0; j < col; j++){
      if(matrix[i][j] == 1){
        left[i][j] = getNum(left, i-1, j-1, row, col) + 1;
        up[i][j] = getNum(up, i-1, j+1, row, col) + 1;
      }
    }
  }
  mrege(left, up, row, col);
  return left;
}
private int rightDown(int[][] matrix, int row, int col){
  int[][] right = new int[row][col];
  int[][] down = new int[row][col];
  for(int i = row-1; i >= 0; i--){
    for(int j = col-1; j >= 0; j--){
      if(matrix[i][j] == 1){
        right[i][j] = getNum(right, i+1, j-1, row, col) + 1;
        down[i][j] = getNum(down, i+1, j+1, row, col) + 1;
      }
    }
  }
  mrege(right, down, row, col);
  return right;

}
private int getNum(int[][] matrix, int x, int y, int row, int col){
  if(x < 0 || x >= row || y < 0 || y >= col){
    return 0;
  }
  return matrix[x][y];

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
