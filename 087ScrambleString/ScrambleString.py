# -*- coding: utf -8-*-

from typing import Dict, List
import sys

sys.setrecursionlimit(5000)

class ScrambleString:
    def isScramble2(self, s1: "str", s2: "str") -> "bool":
        """
        exceed memory limit
        """
        return self.__scramble_helper(s1, s2, {})

    def __scramble_helper(self, s1: "str", s2: "str",
                          map_: "Dict[str, int]") -> "bool":
        ## check map
        key: "str" = s1 + '&' + s2
        ret: "int" = map_.get(key, -1)
        if ret == 1: return True
        if ret == 0: return False
        ## exiting conditions
        if len(s1) != len(s2):
            map_[key] = 0
            return False
        if s1 == s2:
            map_[key] = 1
            return True
        letters: "List[int]" = [0] * 26
        for i in range(len(s1)):
            letters[ord(s1[i]) - ord('a')] += 1
            letters[ord(s2[i]) - ord('a')] -= 1
        for num in letters:
            if num:
                map_[key] = 0
                return False
        ## smaller problem
        for i in range(len(s1)):
            ## cut, next
            if self.__scramble_helper(s1[:i], s2[:i], map_) and\
               self.__scramble_helper(s1[i:], s2[i:], map_):
               map_[key] = 1
               return True
            ## cut, switch, next
            if self.__scramble_helper(
                s1[:i], s2[len(s2) - i:], map_
            ) and self.__scramble_helper(
                s1[i:], s2[:len(s2) - i], map_
            ):
                map_[key] = 1
                return True
        map_[key] = 0
        return False


def main():
    test = ScrambleString()
    print(test.isScramble2("great", "rgeat"))
    print(test.isScramble2("abcde", "caebd"))
    print(test.isScramble2('a', 'a'))

if __name__ == "__main__":
    main()
