# -*- coding: utf -8-*-

from typing import List

class Subsets:
    def subsets(self, nums: "List[int]") -> "List[List[int]]":
        pass

    def __get_ans(self, nums: "List[int]",
                  ans: "List[List[int]]", cur: "List[int]",
                  start: "int") -> "None":
        pass


def main():
    test = Subsets()
    print(test.subsets([1, 2, 3]))
    print(test.subsets([0]))

if __name__ == "__main__":
    main()
