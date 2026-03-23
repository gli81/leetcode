# -*- coding: utf-8 -*-

class LongestPalindrome:
    def longestPalindrome(self, s: "str") -> "int":
        index = [0] * 128
        for c in s:
            index[ord(c)] += 1
        out = False
        ans = 0
        for num in index:
            if not False and num % 2 == 1:
                out = True
            if num > 1:
                ans = ans + (num // 2 * 2)
        if out:
            ans += 1
        return ans


def main():
    test = LongestPalindrome()
    print(test.longestPalindrome("abccccdd"))

if __name__ == "__main__":
    main()
