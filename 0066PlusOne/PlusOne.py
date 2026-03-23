# -*- coding: utf-8 -*-

from typing import List

class PlusOne:
    def plusOne(self, digits: "List[int]") -> "List[int]":
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                return digits
        if digits[0] == 0:
            digits.insert(0, 1)
            return digits
        ## not accessible, just tell compiler to shut up
        return digits


def main():
    test = PlusOne()
    print(test.plusOne([1, 2, 3]))
    print(test.plusOne([4, 3, 2, 1]))
    print(test.plusOne([9]))


if __name__ == "__main__":
    main()
