# -*- coding: utf-8 -*-

from typing import List

class PalindromePartitioning:
    def partition3(self, s: "str") -> "List[List[str]]":
        ans = []
        self.__partitionHelper(s, ans, [], 0)
        return ans

    def __partitionHelper(
        self, s: "str", ans: "List[List[str]]", cur: "List[str]", idx: "int"
    ) -> "None":
        if idx >= len(s):
            ans.append(cur[:])
            return
        for i in range(idx, len(s)):
            if self.__isPalindrome(s[idx : i + 1]):
                cur.append(s[idx : i + 1])
                self.__partitionHelper(s, ans, cur, i + 1)
                ## start from i+1 for next word
                cur.pop()

    def __isPalindrome(self, s: "str") -> "bool":
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]: return False
            l += 1
            r -= 1
        return True

def main():
    test = PalindromePartitioning()
    print(test.partition3("aab"))

if __name__ == "__main__":
    main()
