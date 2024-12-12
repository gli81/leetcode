# -*- coding: utf-8 -*-

class FibonacciNumber:
    def fib1(self, n: "int") -> "int":
        if n == 0:
            return 0
        if n == 1:
            return 1
        dp = [0] * (n + 1)
        dp[1] = 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[-1]
        ## dp[i] --> i th fib num
        ## dp[i] = dp[i - 1] + dp[i - 2]


    def fib2(self, n: "int") -> "int":
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fib2(n - 1) + self.fib2(n - 2)

    def fib3(self, n: "int") -> "int":
        if not n: return 0
        if n == 1: return 1
        ans = 0
        prev = 0
        prev2 = 1
        for _ in range(2, n+1):
            ans = prev + prev2
            prev = prev2
            prev2 = ans
        return ans

def main():
    test = FibonacciNumber()
    print(test.fib1(2))
    print(test.fib1(5))
    print(test.fib1(30))
    print(test.fib2(2))
    print(test.fib2(5))
    print(test.fib2(30))

if __name__ == '__main__':
    main()
