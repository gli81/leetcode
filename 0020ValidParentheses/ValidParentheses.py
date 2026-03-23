# -*- coding: utf-8 -*-

class ValidParentheses:
    def isValid(self, s: str) -> bool:
        container = []
        for i in s:
            if i in ["(", "[", "{"]:
                container.append(i)
            if i == ")":
                if len(container) != 0 and container[-1] == "(":
                    container.pop()
                else: return False
            if i == "]":
                if len(container) != 0 and container[-1] == "[":
                    container.pop()
                else: return False
            if i == "}":
                if len(container) != 0 and container[-1] == "{":
                    container.pop()
                else: return False
        return len(container) == 0

def main():
    print(ValidParentheses().isValid("()"))
    print(ValidParentheses().isValid("()[]\{\}"))
    print(ValidParentheses().isValid("(}"))
    print(ValidParentheses().isValid("([)]"))
    print(ValidParentheses().isValid("{[]}"))


if __name__ == "__main__":
    main()
