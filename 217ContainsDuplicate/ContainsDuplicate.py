# -*- coding: utf-8 -*-

from typing import List

class ContainsDuplicate:
    def containsDuplicate(self, nums: "List[int]") -> "bool":
        ## with List, exceeds time limit
        ## with set, works
        d = set()
        for num in nums:
            if num in d:
                return True
            d.add(num)
        return False


def main():
    test = ContainsDuplicate()
    print(test.containsDuplicate())

if __name__ == "__main__":
    main()
