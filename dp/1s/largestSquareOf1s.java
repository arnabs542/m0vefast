public int largestSquare1s(int[][] matrix){
  int n = matrix.length;
  if(n == 0)
    return 0;
  int res = 0;
  //largest[i][j] means the largest square of 1s with right bottom corner as matrix[i][j]
  int[][] largest = new int[n][n];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      if(matrix[i][j] == 1){
        if(i == 0 || j == 0){
          largest[i][j] = 1;
        }else{
          //as the bottom right corner, make sure other corner is valid to make a square
          largest[i][j] = Math.min(largest[i][j-1] + 1, largest[i-1][j] + 1);
          largest[i][j] = Math.min(largest[i][j], largest[i-1][j-1] + 1);
        }
      }
    res = Math.max(res, largest[i][j]);
  }
  return res;
}
