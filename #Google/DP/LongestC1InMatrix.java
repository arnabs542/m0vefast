//https://massivealgorithms.blogspot.com/search?q=Longest+Line+of+Consecutive+One+in+Matrix
四个方向连续1
h[x][y] = M[x][y] * (h[x - 1][y]  + 1)
v[x][y] = M[x][y] * (v[x][y - 1]  + 1)
d[x][y] = M[x][y] * (d[x - 1][y - 1]  + 1)
a[x][y] = M[x][y] * (a[x + 1][y - 1]  + 1)
//O(mn), O(mn)
public int longestLine(int[][] matrix) {
  //order matter
  int row = matrix.length;
  int max = 0;
  if(row == 0)
    return max;
  int col = matrix[0].length;
  // if(n == 0)
  //   return max;
  //dp[i][j][k]=longest subarray with all 1
  int[][][] dp = new int[row][col][4];
  for(int i = 0; i < row; i++){
    for(int j = 0; j < col; j++){
      if(matrix[i][j] == 1){
        for(int k = 0; k < 4; k++){
          dp[i][j][k] = 1;
        }
        if(j > 0 && matrix[i][j-1] == 1)
          dp[i][j][0] += dp[i][j-1][0]; // horizontal line
        if(i > 0 && matrix[i-1][j] == 1)
          dp[i][j][1] += dp[i-1][j][1]; // vertical line
        if(j > 0 && i > 0 && matrix[i-1][j-1] == 1)
          dp[i][j][2] += dp[i-1][j-1][2]; // diagnoal line
        if(j < col-1 && i > 0 && matrix[i-1][j+1] == 1)
          dp[i][j][3] += dp[i-1][j+1][3]; // anti-diagnoal line
        max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
        max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
      }
    }
  }
  return max;
}
