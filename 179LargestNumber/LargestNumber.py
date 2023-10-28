# -*- coding: utf-8 -*-

from typing import List
from functools import cmp_to_key

class LargestNumber:
    def largestNumber(
        self,
        nums: "List[int]"
    ) -> "str":
        strs = [str(num) for num in nums]
        strs.sort(key = cmp_to_key(self.sort_rule))
        if strs[0] == '0': return '0'
        return ''.join(strs)
    
    def sort_rule(
        self,
        x: "str",
        y: "str"
    ) -> "int":
        a, b = x + y, y + x
        if a < b: return 1
        elif a == b: return 0
        else: return -1
    

def main():
    test = LargestNumber()
    print(test.largestNumber(
        [10, 2]
    ))
    print(test.largestNumber(
        [3, 30, 34, 5, 9]
    ))

if __name__ == "__main__":
    main()
