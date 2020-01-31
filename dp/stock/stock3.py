# what do we need to know about the first i elements when processing the (i+1)th element
# make use of previous computtion
# suppose best solution A[0,j], j between [1, n-1],
def buy_sell_stock2(prices):
    max_profit, min_price_sofar, max_price_sofar = 0.0, float('inf'), float('-inf')
    first_time_profit = [0] * len(prices)

    # forward: max profit(first buy and sell) if we SELL on ith day:
    # tracking min price so far, to sell, we need to know the buy price
    for i, price in enumerate(prices):
        # max_profit_today = price - min_price_sofar
        max_profit = max(max_profit, price - min_price_sofar)  # max_profit_today
        first_time_profit[i] = max_profit   # max profit before ith day

        min_price_sofar = min(min_price_sofar, price)
    # TODO: why backwaards
    # backwards max profit(second buy and sell) if we BUY on the i+1
    # tracking max price so far, to buy, we need to now the sell price
    for i, price in reversed(list(enumerate(prices[1:],1))):
        # combine profit = forward[i-1] + backwards[i], F[-1] = 0, second is after first one
        # same as forward, this time add the forward protion of profit
        max_profit = max(max_profit, max_price_sofar - price + first_time_profit[i-1])

        max_price_sofar = max(max_price_sofar, price)

    return max_total_profit




# brute force: O(n^4) all possible combination of buy-sell-buy-sell
# brute foree: optimized O(n^2) by applying O(n) to each pair of subarrays splitting A
