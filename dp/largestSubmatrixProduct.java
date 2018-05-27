public double largest(double[][] matrix) {
    // Write your solution here
    int row = matrix.length;
    int col = matrix[0].length;
    double[][][] columns = new double[row][row][col]; //dp for all the combinations of top edge, bottom edge, and rightmost column
    double globalMax = matrix[0][0]; //dp matrix for implementing the largest subarray product for each bottom edge
    double[] max = new double[col]; //for each bottom edge, from the 0th column to ith column, the maximum product
    double[] min = new double[col]; //for each bottom edge, from the 0th column to ith column, the minimum product
    for (int i = 0; i < row; i++) {// all the bottom edge
    	for (int j = i; j >= 0; j--) {// all the top edge
      	for (int k = 0; k < col; k++) {// all the rightmost column
          if (i == j) {
          	columns[j][i][k] = matrix[i][k];
          } else {
        	columns[j][i][k] = matrix[i][k] * columns[j][i - 1][k]; // for the kth column, the product from jth row to ith row
          }
          if (k == 0) {
          	max[k] = columns[j][i][k];
            	min[k] = columns[j][i][k];
          } else {// implementing the largest subarray product for each bottom edge
          	max[k] = max(max[k - 1] * columns[j][i][k], min[k - 1] * columns[j][i][k], columns[j][i][k]);
            	min[k] = min(max[k - 1] * columns[j][i][k], min[k - 1] * columns[j][i][k], columns[j][i][k]);
          }
          globalMax = Math.max(globalMax, max[k]);
        }
      }
    }
    return globalMax;
  }
  
  private double min(double a, double b, double c) {
  	double temp = Math.min(a, b);
    	return Math.min(temp, c);
  }

  private double max(double a, double b, double c) {
  	double temp = Math.max(a, b);
    	return Math.max(temp, c);
  }
