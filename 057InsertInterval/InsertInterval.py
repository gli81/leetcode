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
        if len(intervals) == 0:
            ans.append(newInterval)
            return ans
        while index < len(intervals) and \
                intervals[index][1] < new_start:
            ans.append(intervals[index])
            index += 1
        ## everything in intervals added
        ## just add newInterval to the end
        if index == len(intervals):
            start = new_start
            end = new_end
        else:
            start = min(new_start, intervals[index][0])
        while index < len(intervals) and \
                new_end >= intervals[index][0]:
            end = max(new_end, end, intervals[index][1])
            index += 1
        if end == -1: end = new_end
        ans.append([start, end])
        while index < len(intervals):
            ans.append(intervals[index])
            index += 1
        return ans


def main():
    test = InsertInterval()
    print(test.insert([[1, 3], [6, 9]], [2, 5]))
    print(test.insert([[1,2],[3,5],[6,7],[8,10],[12,16]],
                        [4, 8]))
    print(test.insert([[1, 5]], [6, 8]))
    print(test.insert([[1, 5]], [0, 0]))


if __name__ == "__main__":
    main()
