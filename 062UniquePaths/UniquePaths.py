# -*- coding:utf-8 -*-

# from math import factorial

class UniquePaths:

    def uniquePaths(self, m: "int", n: "int") -> "int":
        # return int(
        #     int(factorial(m+n-2)) / int(factorial(n-1)) / int(factorial(m-1))
        # )
        # upper = factorial(m + n - 2)
        # lower = factorial(m - 1) * factorial(n - 1)
        # print(upper, lower)
        # return upper/lower
        n_ = n + m - 2
        k = m - 1
        res = 1
        for i in range(1, k+1):
            res = res * (n_ - k + i) // i
        return res



def main():
    test = UniquePaths()
    print(test.uniquePaths(3, 7))
    print(test.uniquePaths(3, 2))
    print(test.uniquePaths(57, 2))


if __name__ == "__main__":
    main()
