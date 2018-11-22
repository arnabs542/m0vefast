//利用HashSet记录每个island的独立搜索轨迹............
//dfs
public int numberofDistinctIslands(int[][] grid) {
  if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
    return 0;
  Set<String> set = new HashSet<>();
  for(int i = 0; i < grid.length; i++){
    for(int j = 0; j < grid[0].length; j++){
      if(grid[i][j] == 1){
        String path = dfs(grid, i, j);
        set.add(path);
      }
    }
  }
  return set.size();
}
private String dfs(int[][] matrix, int i, int j){
  int[] dx = new int[]{0,1,0,-1};
  int[] dy = new int[]{1, 0, -1, 0};
  String path = "";

  //4 options
  for(int k = 0; k < 4; k++){
    int newX = i+dx[k];
    int newY = j+dy[k];
    //prune
    if(!inBound(matrix, newX, newY) || matrix[newX][newY] == 0)
      continue;
    //step 4: duplicate
    grid[newX][newY] = 0;
    path += k + dfs(matrix, newX, newY);
  }
  //termintion  after 4 options
  return path == "" ? ";" : path;
}






int[] xDirections = new int[] {0, 1, 0, -1};
    int[] yDirections = new int[] {1, 0, -1, 0};
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        Set<String> set = new HashSet<>();

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    String path = dfs(grid, i, j);
                    set.add(path);
                }
            }
        }

        return set.size();
    }

    private String dfs(int[][] grid, int i, int j) {
        String path = "";

        for (int k = 0; k < 4; k++) {
            int x = i + xDirections[k];
            int y = j + yDirections[k];

            if (!isInbound(grid, x, y) || grid[x][y] == 0) {
                continue;
            }
            grid[x][y] = 0;
            path += k + dfs(grid, x, y);
        }

        return path.length() != 0 ? path : ";";
    }

    private boolean isInbound(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return false;
        }

        if (j < 0 || j >= grid[0].length) {
            return false;
        }

        return true;
    }
