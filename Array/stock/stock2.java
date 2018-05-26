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
