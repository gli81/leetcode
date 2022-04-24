# -*- coding: utf-8 -*-

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
        pass


def main():
    print(GenerateParentheses().generateParenthesis(3))


if __name__ == "__main__":
    main()
