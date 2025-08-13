# -*- coding: utf-8 -*-

from typing import List

class CoinChange:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        for x in range(1, amount + 1): ## for each amount
            for coin in coins: ## for each coin
                if x >= coin: ## if the coin can fit in the amount
                    dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float("inf") else -1


def main():
    test = CoinChange()

if __name__ == "__main__":
    main()
