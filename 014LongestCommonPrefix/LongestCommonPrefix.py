# -*- coding: utf-8 -*-

from typing import List

class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: "List[str]") -> "str" :
        ans = ""
        if len(strs) == 0 or strs is None:
            return ""
        ## traverse the first string,
        ## compare every letter to other strings' letter
        ## at the position
        for i in range(len(strs[0])):
            char = strs[0][i]
            for j in range(1, len(strs)):
                ## don't compare strs[0] to strs[0] itself
                if i == len(strs[j]) or char != strs[j][i]:
                    ## if we are out of one of the other strings,
                    ## return current ans
                    return ans
            ## all strs have same character at position i,
            ## add it to the ans
            ans += char
        ## reach the end of first string,
        ## every single character was the same
        ## no more same characters
        ##because no more characters in strs[0]
        return ans


def main():
    print(LongestCommonPrefix().longestCommonPrefix(
        ["flower","flow","flight"]
    ))
    print(LongestCommonPrefix().longestCommonPrefix(
        ["dog","racecar","car"]
    ))

if __name__ == "__main__":
    main()