//1) as most 2 transaction
//2) hold at most one unit of stock: 两次买卖在时间跨度上不能有重叠
public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
    return 0;
  }

  //highest profit in 0 ... i
  int[] left = new int[prices.length];
  int[] right = new int[prices.length];

  // DP from left to right
  left[0] = 0;
  int min = prices[0];
  for (int i = 1; i < prices.length; i++) {
    min = Math.min(min, prices[i]);
    left[i] = Math.max(left[i - 1], prices[i] - min);
  }

  // DP from right to left
  right[prices.length - 1] = 0;
  int max = prices[prices.length - 1];
  for (int i = prices.length - 2; i >= 0; i--) {
    max = Math.max(max, prices[i]);
    right[i] = Math.max(right[i + 1], max - prices[i]);
  }

  int profit = 0;
  for (int i = 0; i < prices.length; i++) {
    profit = Math.max(profit, left[i] + right[i]);
  }

  return profit;
	}

III是这三题中最难的。允许两次买卖，但同一时间只允许持有一支股票。也就意味着这两次买卖在时间跨度上不能有重叠（当然第一次的卖出时间和第二次的买入时间可以是同一天）。既然不能有重叠可以将整个序列以任意坐标i为分割点，分割成两部分：

prices[0:n-1] => prices[0:i] + prices[i:n-1]

对于这个特定分割来说，最大收益为两段的最大收益之和。每一段的最大收益当然可以用I的解法来做。而III的解一定是对所有0<=i<=n-1的分割的最大收益中取一个最大值。为了增加计算效率，考虑采用dp来做bookkeeping。目标是对每个坐标i：

1. 计算A[0:i]的收益最大值：用minPrice记录i左边的最低价格，用maxLeftProfit记录左侧最大收益
2. 计算A[i:n-1]的收益最大值：用maxPrices记录i右边的最高价格，用maxRightProfit记录右侧最大收益。
3. 最后这两个收益之和便是以i为分割的最大收益。将序列从左向右扫一遍可以获取1，从右向左扫一遍可以获取2。相加后取最大值即为答案。

