public int longest(int[][] matrix) {
    // Write your solution here
    if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
      return 0;
    int[] max = new int[1];
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        dfs(matrix, i, j, max, 1);
      }
    }
    return max[0];
}
private void dfs(int[][] matrix, int i, int j, int[] max, int len){
  max[0] = Math.max(max[0], len);

  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};

  for(int k = 0; k < 4; k++){
    int x = i + dx[k];
    int y = j + dy[k];
    if(inBound(x, y, matrix) && matrix[x][y] > matrix[i][j])
      dfs(matrix, x, y, max, len+1);
  }
}
private boolean inBound(int x, int y, int[][] matrix){
  int m = matrix.length;
  int n = matrix[0].length;
  return x >= 0 && x < m && y >= 0 && y < n;
}
