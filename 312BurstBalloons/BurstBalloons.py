# -*- coding: utf-8 -*-

from typing import List

class BurstBalloons:
    def maxCoins(self, nums: "List[int]") -> "int":
        n = len(nums)
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        nums = [1] + nums + [1]
        for i in range(n - 1, -1, -1):
            for j in range(i + 2, n + 2):
                for k in range(i + 1, j):
                    dp[i][j] = max(
                        dp[i][j],
                        nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]
                    )
        return dp[0][n + 1]


def main():
    test = BurstBalloons()
    print(test.maxCoins([3, 1, 5, 8]))

if __name__ == "__main__":
    main()
