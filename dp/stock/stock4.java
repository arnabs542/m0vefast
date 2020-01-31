https://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
https://www.youtube.com/watch?time_continue=16&v=oDhu5uGq_ic
//1) as most k transaction
//2) hold at most one unit of stock: k次买卖在时间跨度上不能有重叠

T[i][j] = max(T[i][j-1] => not making transaction on jth day,
              (max(prices[j]-prices[m]+T[i-1][m]) for m=0->(j-1) =>best you can get by completing transaction (sale) on jth day (and buy before jth day)
                                            finish i-1 transaction till mth day since we buy on mth day
              )
i: total # of transaction
j: day
//O(k*number of days^2)
public int maxProfit(int[] arr, int k){
  int[][] T = new int[k+1][arr.length];
  for(int i = 1; i < T.length; i++){
    for(int j = 1; j < T[0].length; j++){
      int maxValue = 0;
      for(int m = 0; m < j; m++){
        maxValue = Math.max(maxValue, arr[j] - arr[m] + T[i-1][m]);
      }
      T[i][j] = Math.max(T[i][j-1], maxValue);
    }
  }
  return T[k][arr.length-1];
}


