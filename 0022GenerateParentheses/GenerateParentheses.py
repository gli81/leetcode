# -*- coding: utf-8 -*-

from typing import List

class GenerateParentheses:
    def generateParenthesis1(self, n: int) -> list[str]:
        ## brute force
        def isValid(comb: str) -> bool:
            count = 0
            for i in comb:
                if i == "(":
                    count += 1
                else:
                    i -= 1
            return count == 0
        ## generate all combinations

    def generateParenthesis2(self, n: int) -> list[str]:
        ## num '(' <= n
        ## num ')' always <= num '('
        ans = []
        self.__backtrack(ans, 0, 0, '', n)
        return ans

    def __backtrack(
        self, ans: "List[str]", l: "int", r: "int",
        cur: "str", n: "int"
    ) -> "None":
        if (len(cur) == 2 * n):
            ans.append(cur[:])
            return
        if l < n: self.__backtrack(
            ans, l + 1, r, cur + '(', n
        )
        if r < l: self.__backtrack(
            ans, l, r + 1, cur + ')', n
        )


def main():
    print(GenerateParentheses().generateParenthesis2(3))


if __name__ == "__main__":
    main()
