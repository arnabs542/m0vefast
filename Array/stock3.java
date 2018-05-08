//1) as most 2 transaction
//2) hold at most one unit of stock: 两次买卖在时间跨度上不能有重叠
public int maxProfit(int[] array) {
    // Write your solution here
    int n = array.length;
    //max profit so far at position i
    int[] leftProfit = new int[array.length];  //accessing order
    int minPriceLeft = array[0];
    int maxLeftProfit = 0;

    for(int i = 1; i < n; i++){
    	minPriceLeft = Math.min(minPriceLeft, array[i]);
      maxLeftProfit = Math.max(maxLeftProfit, array[i] - minPriceLeft);
      leftProfit[i] = maxLeftProfit;
  	}

    //At most 2 transaction, better profit highter than previous highest
    int profit = leftProfit[n-1];
    int maxPriceRight = array[n-1];
    int maxRightProfit = 0;

    for(int i = n-2; i >= 0; i--){
    	maxPriceRight = Math.max(maxPriceRight, array[i]);
      maxRightProfit = Math.max(maxRightProfit, maxPriceRight - array[i]);
      profit = Math.max(profit, maxRightProfit + leftProfit[i]);
    }
    return profit;
	}
}
