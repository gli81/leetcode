# -*- coding: utf-8 -*-

class ImplementStr:
    def strStr1(self, haystack: "str", needle: "str") -> "int":
        if len(needle) == 0: return 0
        ans = -1
        for i in range(len(haystack) - len(needle) + 1):
            for j in range(len(needle)):
                if haystack[i + j] != needle[j]:
                    break
                if j == len(needle) - 1: return i
        return ans

    def strStr2(self, haystack: str, needle: str) -> int:
        # if len(needle) == 0: return 0
        i = 0
        while True:
            j = 0
            while True:
                if j == len(needle): return i
                if i + j == len(haystack): return -1
                if needle[j] != haystack[i + j]: break
                j += 1
            i += 1


def main():
    test = ImplementStr()
    print(test.strStr2("hello", "ll"))
    print(test.strStr2("aaaaa", "bba"))
    print(test.strStr2("", "a"))
    print(test.strStr2("abc", "c"))

if __name__ == "__main__":
    main()
