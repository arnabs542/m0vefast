def buy_sell_stock1(prices):
    min_price_sofar, max_price_sofar = float('inf'), 0.0
    for price in prices:
        # max_profit = price - min_price_sofar
        max_profit_today = price - min_price_sofar
        max_profit = max(max_profit, max_profit_today)

        min_price_sofar = min(min_price_sofar, price)
    return max_profit
