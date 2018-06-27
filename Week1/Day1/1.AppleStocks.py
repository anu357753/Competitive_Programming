def get_max_profit(stock_price):

    # Calculate the max profit
    if len(stock_price) == 0:
        return "No Stocks"
    if len(stock_price) == 1:
        return "Only One Stock"
    min1 = stock_price[0]
    max1 = stock_price[1] - stock_price[0]

    for i in range(1, len(stock_price)):
    
        max1 = max(max1, stock_price[i]-min1)
        min1 = min(min1,stock_price[i])
        

    return max1

x = input()
print get_max_profit(x)