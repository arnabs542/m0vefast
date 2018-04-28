
//version2: n^3 time
  public int largest(int[][] matrix) {
      // Write your solution here
      int row = matrix.length;
      int col = matrix[0].length;
      //int[][] m = new int[row][col];
      int globalMax = Integer.MIN_VALUE;
      for(int i = 0; i < row; i++){
        int[] cur = new int[col];
        for(int j = i; j < row; j++){
          add(cur, matrix[j]);
          globalMax = Math.max(globalMax, subArrSum(cur));
        }
      }
      return globalMax;
   }
   private void add(int[] cur, int[] add){
     for(int i = 0; i < cur.length; i++){
       cur[i] = cur[i] + add[i];
     }
   }
    private int subArrSum(int[] arr){
      int globalMax = arr[0];
      int localMax = arr[0];
    	for(int i = 1; i < arr.length; i++){
      	localMax = Math.max(arr[i], localMax + arr[i]);
        globalMax = Math.max(globalMax, localMax);
      }
      return globalMax;
    }
    //verison1: unfinished, n^4 time
    public int largestSubmatrixSum(int[][] matrix) {
        // Write your solution here
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] m = new int[row][col];
        int globalMax = Integer.MIN_VALUE;
        //1) column wise, panbian
        for(int j = 0; j < col; j++){
           m[0][j] = matrix[0][j];
        }
        for(int i = 1; i < row; i++){
          //int[] cur = new int[col];
        	for(int j = 0; j < col; j++){
            m[i][j] = m[i-1][j] + matrix[i][j];
          }
        }
        //2) row wise
        for(int i = 0; i < row; i++){
        	for(int j = 1; j < col; j++){
            m[i][j] += m[i][j-1];
          }
          //not correct from here
          //3) subarrSum
          globalMax = Math.max(globalMax, subArrSum(m[i]));
        }

        return globalMax;
      }
      private int subArrSum(int[] arr){
        int globalMax = arr[0];
        int localMax = arr[0];
      	for(int i = 1; i < arr.length; i++){
        	localMax = Math.max(arr[i], localMax + arr[i]);
          globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
      }
