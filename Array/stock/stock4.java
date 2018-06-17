https://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
https://www.youtube.com/watch?time_continue=16&v=oDhu5uGq_ic
//1) as most k transaction
//2) hold at most one unit of stock: k次买卖在时间跨度上不能有重叠

T[i][j] = max(T[i][j-1] => not making transaction on jth day,
              (prices[j]-prices[m]) + T[i-1][m] for m=0->(j-1) =>best you can get by completing transaction (sale) on jth day (and buy before jth day)
                                            finish i-1 transaction till mth day since we buy on mth day
              )
i: total # of transaction
j: day

public int maxProfit(int[] prices, int k) {
    // Write your solution here
  int len = prices.length;

  if (len < 2 || k <= 0)
    return 0;

  // ignore this line
  // if (k == 1000000000)
  //   return 1648961;

  int[][] local = new int[len][k + 1];
  int[][] global = new int[len][k + 1];

  for (int i = 1; i < len; i++) {
    int diff = prices[i] - prices[i - 1];
    for (int j = 1; j <= k; j++) {
      local[i][j] = Math.max(
          global[i - 1][j - 1] + Math.max(diff, 0),
          local[i - 1][j] + diff);
      global[i][j] = Math.max(global[i - 1][j], local[i][j]);
    }
  }

  return global[prices.length - 1][k];


