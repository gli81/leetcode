# -*- coding: utf -8-*-

from typing import Dict

class EditDistance:
    def minDistance1(self, word1: "str", word2: "str") -> "int":
        ## over time limit
        if len(word1) == 0 and len(word2) == 0: return 0
        if len(word1) == 0: return len(word2)
        if len(word2) == 0: return len(word1)
        x = self.minDistance1(word1, word2[:-1]) + 1
        y = self.minDistance1(word1[:-1], word2) + 1
        z = self.minDistance1(word1[:-1], word2[:-1])
        if word1[-1] != word2[-1]: z += 1
        return min(x, y, z)

    def minDistance2(self, word1: "str", word2: "str") -> "int":
        return self.__helper(word1, word2)

    def __helper(self, word1: "str", word2: "str",
                d: "Dict" = {}) -> "int":
        if len(word1) == 0 and len(word2) == 0: return 0
        if len(word1) == 0: return len(word2)
        if len(word2) == 0: return len(word1)
        key = word1 + '_' + word2
        if key in d: return d[key]
        else:
            x = self.__helper(word1, word2[:-1], d) + 1
            y = self.__helper(word1[:-1], word2, d) + 1
            z = self.__helper(word1[:-1], word2[:-1], d)
            if word1[-1] != word2[-1]: z += 1
            d[key] = min(x, y, z)
            return min(x, y, z)



def main():
    test = EditDistance()
    print(test.minDistance2("horse", "ros"))
    print(test.minDistance2("intention", "execution"))

if __name__ == "__main__":
    main()
