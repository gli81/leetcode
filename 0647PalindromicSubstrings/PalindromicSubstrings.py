# -*- coding: utf-8 -*-

from typing import List

class NumberofIslands:
    def countSubstrings(self, s: str) -> int:
        ## each char as center
        n = len(s)
        ans = 0
        for i in range(n):
            for j in range(2):
                l = i
                r = i + j
                while l >= 0 and r < n and s[l] == s[r]:
                    l -= 1
                    r += 1
                    ans += 1
        return ans


def main():
    pass

if __name__ == "__main__":
    main()
