# -*- coding: utf-8 -*-

class IntegertoRoman:
    def intToRoman(self, num: int) -> str:
        ## define two lists wiht corresponding int and roman num
        nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        roms = [
            "M", "CM", "D", "CD", "C", "XC", "L",
            "XL", "X", "IX", "V", "IV", "I"
        ]
        ans = ""
        for i in range(len(nums)):
            while num >= nums[i]:
                num -= nums[i]
                ans += roms[i]
        return ans


def main():
    testCases = [
        1, 2, 3, 4, 5, 9, 10, 14, 15, 19, 21, 25, 58, 99,
        100, 101, 499, 500, 501, 999, 1000, 1001
    ]
    for i in testCases:
        print(IntegertoRoman().intToRoman(i))

if __name__ == "__main__":
    main()

