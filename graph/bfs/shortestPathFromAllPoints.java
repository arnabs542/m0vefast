//Build Post Office II完全一样的题，从每个建筑开始BFS，找最短路径的和。
//similar to wallsAndGates
http://www.cnblogs.com/grandyang/p/5297683.html
    public int shortestDistance(int[][] grid) {
        // write your code here
        int row = grid.length;
        int col = grid[0].length;
        int[][] disMap = new int[row][col];//记录每个building 到每个空地的距离和
        int[][] emptySpace = new int[row][col];//记录有些不能被所有building reach的空地
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    disMap[i][j] = -1;
                }
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                   bfs(grid, i, j, disMap, emptySpace);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (disMap[i][j] != -1 && emptySpace[i][j] != -1) {
                   result = Math.min(result, disMap[i][j]);
                }
            }
        }

        return result ==Integer.MAX_VALUE ? -1 : result;
    }

    private void bfs(int[][] grid, int a, int b, int[][] disMap, int[][] emptySpace) {
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        int row = grid.length;
        int col = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        queue.offer(new Point(a, b));

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int m = 0; m < size; m++) {
                Point current = queue.poll();
                for (int n = 0; n < 4; n++) {
                    Point adj = new Point(current.x + deltaX[n], current.y + deltaY[n]);
                    if (inBound(grid, adj)
                    && grid[adj.x][adj.y] == 0
                    && visited[adj.x][adj.y] == 0){
                      disMap[adj.x][adj.y] += step;
                      visited[adj.x][adj.y] = 1;
                      queue.offer(adj);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 ) {//记录不能reach所有building的空地
                   emptySpace[i][j] = -1;
                }
            }
        }
    }

    private boolean inBound(int[][] grid, Point adj) {
        int row = grid.length;
        int col = grid[0].length;
        return adj.x >= 0 && adj.x < row && adj.y >=0 && adj.y < col;
    }

//solution2: O(n) O(n);

// 我们对于每一个建筑的位置都进行一次全图的BFS遍历，每次都建立一个dist的距离场，由于我们BFS遍历需要标记应经访问过的位置，
// 而我们并不想建立一个visit的二维矩阵，那么怎么办呢，这里用一个小trick，我们第一遍历的时候，都是找0的位置，遍历完后，我们将其赋为-1
//这样下一轮遍历我们就找-1的位置，然后将其都赋为-2，以此类推直至遍历完所有的建筑物
public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[][] totalDistance = new int[m][n];
        int step = 0;
        int res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {   //if building
                    res = bfs(grid, i, j, step, totalDistance);
                    step--;
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int bfs(int[][] grid, int x, int y, int step, int[][] totalDistance) {
        int res = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};

        Queue<Integer> queue = new LinkedList<>();  //all empty space
        queue.offer(x * n + y);
        int curDis = 0;  //from curretn building

        while (!queue.isEmpty()) {
            int size = queue.size();
            curDis++;
            while (size > 1) {
                Point cur = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    Point adj = new Point(
                      cur.x + deltaX[i],
                      cur.y + deltaY[i]);
                    //if empty space
                    if (inBound(adj, grid) && grid[adj.x][adj.y] == step) {
                        queue.offer(adj);
                        totalDistance[adj.x][adj.y] += curDis;  //+ antoher bulding to this empty space
                        grid[adj.x][adj.y]--;
                        res = Math.min(res, totalDistance[adj.x][adj.y]);
                    }
                }
            }
        }
        return res;
    }
