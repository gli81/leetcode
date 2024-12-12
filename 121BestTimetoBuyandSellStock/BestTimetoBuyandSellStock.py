# -*- coding: utf-8 -*-

from typing import List

class BestTimetoBuyandSellStock:
    def maxProfit2(self, prices: "List[int]") -> "int":
        ans = 0
        j = 0
        for i in range(len(prices)):
            if (prices[i] - prices[j] > ans):
                ans = prices[i] - prices[j]
            elif (prices[i] - prices[j] < 0): j = i
        return ans


def main():
    test = BestTimetoBuyandSellStock()
    print(test.maxProfit2([7, 1, 5, 3, 6, 4]))
    print(test.maxProfit2([7, 6, 4, 3, 1]))

if __name__ == "__main__":
    main()
