# -*- coding: utf-8 -*-

class FirstMissingPos():
    def firstMissingPos(self, nums: "list[int]"):
        check = [0] * len(nums)
        for i in nums:
            if i > 0: check[i - 1] = 1
        try: ans = check.index(0) + 1
        except ValueError: ans = len(check) + 1
        return ans

def main():
    test = FirstMissingPos()
    print(test.firstMissingPos([1, 2, 0]))
    print(test.firstMissingPos([1, 2, 3]))

if __name__ == "__main__":
    main()

