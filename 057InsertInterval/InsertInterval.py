# -*- coding:utf-8 -*-

from typing import List

class InsertInterval:
    def insert(self, intervals: "List[List[int]]", 
               newInterval: "List[int]") -> "List[List[int]]":
        pass


def main():
    test = InsertInterval()
    print(test.insert([[1, 3], [6, 9]], [2, 5]))
    print(test.insert([[1,2],[3,5],[6,7],[8,10],[12,16]],
                        [4, 8]))


if __name__ == "__main__":
    main()
