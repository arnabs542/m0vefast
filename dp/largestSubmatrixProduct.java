//another
  //其实这个题目和从largest subarray sum扩展到largest submatrix sum一样，
  //我们也可以从largest subarray product扩展到largest submatrix product。
  //我们还是可以用同样的方法把submatrix每一个column拍扁来做。
  //如果你还没学到largest submatrix sum的话，可以先等等再做这个题，后面会讲到
  //https://piazza.com/class/j0eqhhdregb3i?cid=712
  public double largest(double[][] matrix) {
      // Write your solution here
      double globalMax = matrix[0][0];
      for (int i = 0; i < matrix.length; i++) {
        double[] cur = new double[matrix[0].length];
        for (int j = i; j < matrix.length; j++) {
          getArr(cur, matrix[j], j - i);
          globalMax = Math.max(largestProduct(cur), globalMax);
        }
      }
      return globalMax;
    }
    //idx here is different from submatrix sum: cur initialize as all 0
    private double[] getArr(double[] cur, double[] source, int idx) {
      for (int i = 0; i < cur.length; i++) {
        cur[i] = idx == 0 ? source[i] : source[i] * cur[i];
      }
      return cur;
    }
    public double largestProduct(double[] array) {
      if (array.length == 1) return array[0];
      double pos = Math.max(array[0], 0);
      double neg = Math.min(array[0], 0);
      double globalMax = array[0];
      for (int i = 1; i < array.length; i++) {
        if (array[i] > 0) {
          pos = Math.max(pos * array[i], array[i]);
          neg = neg * array[i];
        } else if (array[i] < 0) {
          double prev = pos;
          pos = neg * array[i];
          neg = Math.min(prev * array[i], array[i]);
        } else {
          pos = 0;
          neg = 0;
        }
        globalMax = Math.max(globalMax, pos);
      }
      return globalMax;
    }
