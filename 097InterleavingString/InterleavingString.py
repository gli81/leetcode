# -*- coding: utf-8 -*-

from typing import Dict

class InterleavingString:
    def isInterleave1(
        self, s1: "str", s2: "str", s3: "str") -> "bool":
        '''
        backtracking
        over time limit
        '''
        return self.__get_ans(s1, s2, s3, 0, 0, 0)

    def __get_ans(
        self, s1: "str", s2: "str", s3: "str", i: "int", j: "int", k: "int"
    ) -> "bool":
        ## ending conditions
        ## different length
        if len(s1) + len(s2) != len(s3): return False
        ## return True
        ## if i reaches s1 end &&
        ##    j reaches s2 end &&
        ##    k reaches s3 end
        if i == len(s1) and j == len(s2) and len(s3) == k:
            return True
        ## i at s1 end, move j
        if i == len(s1):
            while j < len(s2):
                if s2[j] != s3[k]: return False
                j += 1
                k += 1
            ## j reaches s2 end, len(s1) + len(s2) = len(s3)
            ## so k reaches s3 end
            return True
        ## j at s2 end, move i
        if j == len(s2):
            while i < len(s1):
                if s1[i] != s3[k]: return False
                i += 1
                k += 1
            return True
        if s1[i] == s3[k]:
            if self.__get_ans(s1, s2, s3, i + 1, j, k + 1):
                return True
        if s2[j] == s3[k]:
            if self.__get_ans(s1, s2, s3, i, j + 1, k + 1):
                return True
        return False

    def isInterleave2(
        self, s1: "str", s2: "str", s3: "str"
    ) -> "bool":
        '''
        backtracking with memoization
        '''
        return self.__get_ans2(s1, s2, s3, 0, 0, 0)

    """
    Python默认参数为list或dict的话，默认参数只在函数定义时创建一个
    后续调用都不断使用这一个，真傻逼
    https://segmentfault.com/a/1190000018949902
    """

    def __get_ans2(
        self, s1: "str", s2: "str", s3: "str", i: "int",
        j: "int", k: "int", memo: "Dict[str, bool]"=None
    ) -> "bool":
        # print(memo)
        ## ending conditions
        ## different length
        if len(s1) + len(s2) != len(s3): return False
        ## return True
        ## if i reaches s1 end &&
        ##    j reaches s2 end &&
        ##    k reaches s3 end
        if memo is None: memo = {}
        key = str(i) + '@' + str(j)
        # print(key)
        if key in memo.keys(): return memo[key]
        if i == len(s1) and j == len(s2) and len(s3) == k:
            # print(memo)
            memo[key] = True
            # print(memo)
            return True
        ## i at s1 end, move j
        if i == len(s1):
            while j < len(s2):
                if s2[j] != s3[k]:
                    memo[key] = False
                    return False
                j += 1
                k += 1
            ## j reaches s2 end, len(s1) + len(s2) = len(s3)
            ## so k reaches s3 end
            memo[key] = True
            return True
        ## j at s2 end, move i
        if j == len(s2):
            while i < len(s1):
                if s1[i] != s3[k]:
                    memo[key] = False
                    return False
                i += 1
                k += 1
            memo[key] = True
            return True
        if s1[i] == s3[k]:
            if self.__get_ans2(s1, s2, s3, i + 1, j, k + 1, memo):
                memo[key] = True
                return True
        if s2[j] == s3[k]:
            if self.__get_ans2(s1, s2, s3, i, j + 1, k + 1, memo):
                memo[key] = True
                return True
        memo[key] = False
        return False


def main():
    test = InterleavingString()
    print(test.isInterleave2("aabcc", "dbbca", "aadbbbaccc"))
    print(test.isInterleave2('', '', ''))
    print(test.isInterleave2(
        "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
    ))

if __name__ == "__main__":
    main()
