https://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
//didnt pass!!!!!!!!!!!!!!!!1
public int maxProfit(int[] array, int k) {
    // Write your solution here
    int len = array.length;
    if(k >= len/2)
      return quickSolve(array);
    int[][] matrix = inew int[k+1][len];
    for(int i = 1; i <= k; i++){
      int tempMax = -array[0];
      for(int j = 1; j < len; j++){
        matrix[i][j] = Math.max(matrix[i][j-1], holding + prices[j]);
        tempMax = Math.max(holding, t[i - 1][j - 1] - prices[j]);
      }
    }
    return matrix[k][len-1];
}
private int quickSolve(int[] array){
  int len = array.length;
  int profit = 0;
  for(int i = 1; i < len; i++){
    if(array[i] > array[i-1]){
      profit += array[i] - array[i-1];
    }
  }
  return profit;
}

//N^3 solution
public int maxProfit(int[] array, int k) {
  int matrix[][] = new int[k+1][array.length];
  for(int i = 1; i < matrix.length; i++){
    for(int j = 1; j < matrix[0].length; j++){
      int maxVal = 0;
      for(int m = 0; m < j; m++){
        maxVal = Math.max(maxVal, array[i] - array[m] + matrix[i-1][m]);
      }
      matrix[i][j] = Math.max(matrix[i][j-1], maxVal);
    }
  }
  return matrix[k][array.length-1];

}
