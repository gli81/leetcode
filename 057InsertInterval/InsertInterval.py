# -*- coding:utf-8 -*-

from typing import List

class InsertInterval:
    def insert(self, intervals: "List[List[int]]", 
               newInterval: "List[int]") -> "List[List[int]]":
        start = -1
        end = -1
        new_start = newInterval[0]
        new_end = newInterval[1]
        ans = []
        index = 0
        while index < len(intervals):
            if intervals[index][1] < new_start:
                ans.append(intervals[index]) 
            

    def __in(self, interval: "List[int]",
                isin: "int") -> "bool":
        return interval[1] >= isin >= interval[0]


def main():
    test = InsertInterval()
    print(test.insert([[1, 3], [6, 9]], [2, 5]))
    print(test.insert([[1,2],[3,5],[6,7],[8,10],[12,16]],
                        [4, 8]))


if __name__ == "__main__":
    main()
