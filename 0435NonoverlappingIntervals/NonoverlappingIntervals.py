# -*- coding: utf-8 -*-

from typing import List

class NonoverlappingIntervals:
    def eraseOverlapIntervals(self,
                              intervals: "List[List[int]]")\
                              -> "int":
        ## 先排序
        ## 遍历数组找到最大能fit多少intervals
        ## 如果按intervals[i][0]排序会遇到一个问题
        ## 如果遇到[1,100]这样的会导致后面的全都不能被选中
        ## 选择用intervals[i][1]排序会避免这个问题
        ## 但我想要逻辑更严密的证明??????????
        ## ??????????
        intervals.sort(key=lambda x : x[1])
        # print(intervals)
        cur = 0
        ans = 1
        for i in range(1, len(intervals)):
            if intervals[i][0] >= intervals[cur][1]:
                ans += 1
                cur = i
        return len(intervals) - ans


def main():
    test = NonoverlappingIntervals()
    print(
        test.eraseOverlapIntervals(
            [[1, 2], [2, 3], [3, 4], [1, 3]]
        )
    )

if __name__ == "__main__":
    main()
