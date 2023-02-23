# -*- coding:utf-8 -*-

from typing import List

class MergeIntervals:
    def merge(self, intervals: "List[List[int]]") \
                -> "List[List[int]]":
        pass


def main():
    test = MergeIntervals()
    print(test.merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print(test.merge([[1, 4], [4, 5]]))


if __name__ == "__main__":
    main()
