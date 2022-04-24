# -*- coding: utf-8 -*-



class ZigZagConversion2:
    def convert(self, s: str, numRows: int) -> str:
        n = len(s)
        if numRows == 1: return s
        ## a cycle for 4 rows is abcdef ghijkl
        cycle = numRows * 2 - 2
        ans = ""
        for i in range(numRows):
            for j in range(0, n - i, cycle):
                ans += s[i + j]
                if i != 0 and i != numRows - 1 and j < (n + i - cycle):
                    ans += s[j - i + cycle]
        return ans


def main():
    s : str = "abcdefghijklmnopqrstuvwxyz"
    # lcAns = "PAHNAPLSIIGYIR"
    print(ZigZagConversion2().convert(s, 3))

if __name__ == '__main__':
    main()