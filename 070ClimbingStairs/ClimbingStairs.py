# -*- coding: utf -8-*-

from typing import Dict

class ClimbingStairs:
    def climbStairs(self, n: "int") -> "int":
        return self.__climb(n, {})

    def __climb(self, n: "int", save: "Dict[int, int]") -> "int":
        if n in [1, 2]: return n
        n1 = n2 = 0
        if n - 1 in save: n1 = save[n - 1]
        else:
            n1 = self.__climb(n - 1, save)
            save[n - 1] = n1
        if n - 2 in save: n2 = save[n - 2]
        else:
            n2 = self.__climb(n - 2, save)
            save.update({n - 2: n2})
        return n1 + n2
    
    def climbStairs_dp(self, n: "int") -> "int":
        if n in [1, 2]: return n
        dp = [0] * n
        dp[0] = 1
        dp[1] = 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n - 1]


def main():
    test = ClimbingStairs()
    print(test.climbStairs_dp(1))
    print(test.climbStairs_dp(2))
    print(test.climbStairs_dp(3))
    print(test.climbStairs_dp(45))

if __name__ == "__main__":
    main()
    