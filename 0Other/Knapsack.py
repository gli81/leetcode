# -*- coding: utf-8 -*-

from typing import List

def knapsack(
    values: "List[int]",
    weights: "List[int]",
    capacity: "int"
) -> "int":
    dp = [[0 for _ in range(capacity + 1)] for _ in range(len(weights) + 1)]
    for i in range(1, len(weights) + 1):
        for j in range(len(dp[0])):
            # use_it =
            dp[i][j] = max(
                dp[i - 1][j],
                dp[i - 1][j - weights[i - 1]] + values[i - 1] \
                    if weights[i - 1] <= j else 0
            )
    for row in dp:
        print(row)
    return dp[-1][-1]


def main():
    print(knapsack([2, 2, 4, 5, 3], [3, 1, 3, 4, 2], 7))

if __name__ == "__main__":
    main()
