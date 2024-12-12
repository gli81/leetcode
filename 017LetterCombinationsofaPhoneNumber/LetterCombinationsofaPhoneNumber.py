# -*- coding: utf-8 -*-

from typing import List

class LetterCombinationsofaPhoneNumber:
    __KEYS = [
        '', '', "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ]
    def letterCombinations1(self, digits: "str") -> "List[str]":
        pass

    def letterCombinations3(self, digits: "str") -> "List[str]":
        if len(digits) == 0: return []
        ans = []
        self.__combHelper(digits, ans, '', 0)
        return ans

    def __combHelper(
        self, digits: "str", ans: "List[str]", pre: "str", len_: "int"
    ) -> "None":
        if len_ == len(digits):
            ans.append(pre)#.copy())
            return
        letters = self.__KEYS[int(digits[len_])]
        for c in letters:
            self.__combHelper(digits, ans, pre + c, len_ + 1)


def main():
    test = LetterCombinationsofaPhoneNumber()
    print(test.letterCombinations3("25"))

if __name__ == "__main__":
    main()
