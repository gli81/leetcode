# -*- coding: utf-8 -*-

from typing import List

class MaximalSquare:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        dp
        """
        r = len(matrix)
        if r == 0: return 0
        c = len(matrix[0])
        dp = [[0 for _ in row] for row in matrix]
        max_ = 0
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = min(
                            dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]
                        ) + 1
                    max_ = max(max_, dp[i][j])
        return max_ * max_
