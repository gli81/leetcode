# -*- coding:utf-8 -*-

from typing import List

class MergeIntervals:
    def merge(self, intervals: "List[List[int]]") \
                -> "List[List[int]]":
        ans = []
        if len(intervals) == 0 : return ans
        intervals.sort(key=lambda x:x[0])
        # print(intervals)
        cur_left = intervals[0][0]
        cur_right = intervals[0][1]
        ans.append(intervals[0])
        for i in range(1, len(intervals)):
            if intervals[i][0] > cur_right:
                ans.append(intervals[i].copy())
                cur_left = intervals[i][0]
                cur_right = intervals[i][1]
            else:
                if intervals[i][1] > cur_right:
                    ans.pop()
                    ans.append([cur_left, intervals[i][1]])
                    cur_right = intervals[i][1]
        return ans


def main():
    test = MergeIntervals()
    print(test.merge([[1, 3], [2, 6], [8, 10], [15, 18]]))
    print(test.merge([[1, 4], [4, 5]]))


if __name__ == "__main__":
    main()
