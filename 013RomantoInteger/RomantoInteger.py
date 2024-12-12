# -*- coding: utf-8 -*-


class RomantoInteger:
    def romanToInteger(self, s: str) -> int:
        ans = 0
        ## str.find() vs str.index()
        ## find -1, index exception
        ## there is IV, the loop would add 6, but actually it is a 4
        if s.find("IV") != -1: ans = ans - 2
        if s.find("IX") != -1: ans = ans - 2
        if s.find("XL") != -1: ans = ans - 20
        if s.find("XC") != -1: ans = ans - 20
        if s.find("CD") != -1: ans = ans - 200
        if s.find("CM") != -1: ans = ans - 200

        ## traverse the string, add up each roman num
        for char in s:
            if char == "I": ans += 1
            if char == "V": ans += 5
            if char == "X": ans += 10
            if char == "L": ans += 50
            if char == "C": ans += 100
            if char == "D": ans += 500
            if char == "M": ans += 1000
        return ans


def main():
    testCase = ["I", "II", "III", "IV", "V", "VI", "IX", "CMDLVI"]
    for test in testCase:
        print(RomantoInteger().romanToInteger(test))


if __name__ == "__main__":
    main()
