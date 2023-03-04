# -*- coding:utf-8 -*-

import math

class UniquePaths:
    def uniquePaths3(self, m: "int", n: "int") -> "int":
        # return int(int(math.factorial(m+n-2)) / int(math.factorial(n-1)) / int(math.factorial(m-1)))
        upper = math.factorial(m + n - 2)
        lower = math.factorial(m - 1) * math.factorial(n - 1)
        print(upper, lower)
        return upper/lower
    
    def uniquePaths1(self, m: "int", n: "int") -> "int":
        # return int(int(math.factorial(m+n-2)) / int(math.factorial(n-1)) / int(math.factorial(m-1)))
        upper = math.factorial(m + n - 2)
        lower = math.factorial(m - 1) * math.factorial(n - 1)
        print(upper, lower)
        return upper/lower


def main():
    test = UniquePaths()
    print(test.uniquePaths(3, 7))
    print(test.uniquePaths(3, 2))
    print(test.uniquePaths(57, 2))


if __name__ == "__main__":
    main()
