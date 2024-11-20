# -*- coding: utf-8 -*-

from typing import List

class PalindromePairs:
    def palindromePairs1(
        self,
        words: "List[str]"
    ) -> "List[List[int]]":
        pass
    
    def palindromePairs2(
        self,
        words: "List[str]"
    ) -> "List[List[int]]":
        """
        Hashmap
        """
        mvp = {}
        for idx, w in enumerate(words):
            mvp[w[::-1]] = idx
        # print(mvp)
        ans = []
        for idx, w in enumerate(words):
            len_ = len(w)
            if not len_: continue
            for i in range(len_+1):
                if self.__isPalindrome(w, i, len_ - 1):
                    ## latter part is palindrome
                    ## if former part has reverse
                    ## add to ans
                    if w[:i] in mvp and mvp[w[:i]] != idx:
                        ans.append([idx, mvp[w[:i]]])
                if i != 0 and self.__isPalindrome(w, 0, i - 1):
                    ## former part is palindrome
                    ## if latter part has reverse
                    ## add to ans
                    if w[i:] in mvp and mvp[w[i:]] != idx:
                        ans.append([mvp[w[i:]], idx])
        return ans

    
    def __isPalindrome(self, w: "str", l: "int", r: "int") -> "bool":
        while l < r:
            if w[l] != w[r]: return False
            l += 1
            r -= 1
        return True


def main():
    test = PalindromePairs()
    print(test.palindromePairs2(["abcd", "dcba", "lls", "s", "sssll"]))
    print(test.palindromePairs2(["", "s"]))

if __name__ == "__main__":
    main()
