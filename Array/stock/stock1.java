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
