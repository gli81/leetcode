# -*- coding: utf-8 -*-

from typing import List

class WordBreak:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True ## empty string is fine
        for i in range(1, len(s) + 1):
            for j in range(i):
                ## check each segmentation before i for s[:j] and s[j:i]
                if dp[j] and s[j : i] in wordSet:
                    dp[i] = True
                    break
        return dp[-1]


def main():
    test = WordBreak()

if __name__ == "__main__":
    main()
