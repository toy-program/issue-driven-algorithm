def coinChange(self, coins: List[int], amount: int) -> int:
    INFI = amount+1
    
    dp = [INFI] * INFI
    dp[0] = 0

    for coin in coins:
        for i in range(coin, amount+1):
            if dp[i - coin] != INFI:
                dp[i] = min(dp[i], dp[i-coin]+1)

    if dp[amount] == INFI:
        return -1
    return dp[amount]