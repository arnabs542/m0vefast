// http://bangbingsyb.blogspot.ca/2014/11/leetcode-best-time-to-buy-and-sell.html
// 1) at most one transaction
public int maxProfit(int[] array) {
    // Write your solution here
    int profit = 0;
    int min = array[0];
    for(int i = 1; i < array.length; i++){
      profit = Math.max(profit, array[i] - min);
      min = Math.min(min, array[i]);
    }
    return profit;
}
I限制了只能买卖一次。于是要尽可能在最低点买入最高点抛出。这里的一个隐含的限制是抛出的时间必须在买入的时间之后。所以找整个数组的最大最小值之差的方法未必有效，因为很可能最大值出现在最小值之前。但是可以利用类似思路，在扫描数组的同时来更新一个当前最小值minPrice。这样能保证当扫到i时，minPrices必然是i之前的最小值。当扫到i时：

如果prices[i] < minPrice，则更新minPrice = prices[i]。并且该天不应该卖出。
如果prices[i] >= minPrice，则该天可能是最好的卖出时间，计算prices[i] - minPrice，并与当前的单笔最大利润比较更新。