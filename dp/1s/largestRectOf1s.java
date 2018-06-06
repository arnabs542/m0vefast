//Method 2: O(m*n), O(m*n)
// 第二个方法就是利用汤老师上课讲的找histogram的最大长方形，对于找到最长连续1的新的matrix，
// 每一行用这个方法找一遍最大的长方形，这个方法的时间复杂度就是O(mn)
  public int largest(int[][] matrix) {
    // corner case:
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int globalMax = 0;
    //no need for 2 for=loop, need to pass the entire matrix
    int[][] top = top(matrix, row, col);
    for (int i = 0; i < row; i++) {
        globalMax = Math.max(largestRectangle(top[i]), globalMax);
    }
    return globalMax;
  }
  //rectangleHistogram
  private int largestRectangle(int[] array) {
    Deque<Integer> stack = new LinkedList<>();
    int largest = 0;
    for (int i = 0; i <= array.length; i++) {
        int cur = i == array.length ? 0 : array[i];
        while (!stack.isEmpty() && cur < array[stack.peekFirst()]) {
            int height = array[stack.pollFirst()];
            int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
            largest = Math.max(largest, (i - left) * height);
        }
        stack.offerFirst(i);
    }
    return largest;
  }

// helper functions
 // top[i][j] means how many column wise consecutive 1s
  private int[][] top(int[][] matrix, int row, int col) {
    int[][] top = new int[row][col];
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (matrix[i][j] == 1) {
                top[i][j] = getNumber(top, i - 1, j) + 1;
            }
        }
    }
    return top;
  }
  private int getNumber(int[][] top, int x, int y) {
    if (x < 0) {
      return 0;
    }
    return top[x][y];
  }

// Method 1: O(n*m^2), O(m*n)
// 我的思路是step1. 从上到下的direction找连续最长1存入一个新的matrix里 step2.
// 遍历这个新的matrix，把每个点当作长方形的右下顶点，看能组成多大面积的长方形，这里我用了两个方法，
// 第一个方法比较intuitive，就是从这个点出发往左边一直找，不断根据左边元素更新minHeight，
//不断算出最大面积来更新，这个方法的时间复杂度是O(n*m^2) [n is the row of the matrix, m is the column of the matrix],
    public int largest(int[][] matrix) {
        // corner case:
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int N = matrix.length;
        int M = matrix[0].length;

        int globalMax = 0;

        int[][] top = top(matrix, N, M);
        // choose each point as the right bottom point of the rectangle
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                int max = 0;
                if (matrix[row][col] == 1) {
                    int minHeight = top[row][col];
                    for (int i = col; i >= 0; i--) {
                        minHeight = Math.min(minHeight, top[row][i]);
                        max = Math.max(max, (col - i + 1) * minHeight);
                    }
                }
                globalMax = Math.max(globalMax, max);
            }
        }
        return globalMax;
    }
