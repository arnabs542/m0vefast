//1) as many transactions
//2) hold at most one unit of stock: 两次买卖在时间跨度上不能有重叠
public int maxProfit(int[] array) {
    // Write your solution here
    int profit = 0;
    for(int i = 1; i < array.length; i++){
      profit += array[i] - array[i-1] ? array[i] - array[i-1] : 0;
    }
    return profit;
}
II并没有限制总的买卖次数，只限制了当天只能买或卖。所以可以采用greedy的方法，来获得所有可能的正利润。以如下序列说明：

2 1 3 4 5 4 2 8 7

只要prices[i] - prices[i-1]>0，我们就在第i-1天买入，第i天抛出。这样可以包括所有可能赚取利润的区间。
