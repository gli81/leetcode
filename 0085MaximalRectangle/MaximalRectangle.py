# -*- coding: utf -8-*-

from typing import List

class MaximalRectangle:
    def maximalRectangle(self,
                        matrix: "List[List[str]]") -> "int":
        """
        transform into 084
        """
        # return 0
        if not matrix: return 0
        if not matrix[0]: return 0
        ## get heights for every row
        max_area = 0
        heights = [0] * len(matrix[0])
        ## => deal with len(matrix) == 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                ## update heights array, not create every time
                if matrix[i][j] == '1': heights[j] += 1
                else: heights[j] = 0
            ## 084
            area = self.largestRectangleinHistogram4(heights)
            max_area = max(area, max_area)
        return max_area

    def largestRectangleinHistogram4(self,
                                     heights: "List[int]") -> "int":
        len_ = len(heights)
        left_first_shorter = [_ - 1 for _ in range(len_)]
        right_first_shorter = [_ + 1 for _ in range(len_)]
        max_area = 0
        ## update left_first_shorter
        for i in range(1, len_):
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p = left_first_shorter[p]
            left_first_shorter[i] = p
        for i in range(len_ - 2, -1, -1):
            p = i + 1
            while p < len_ and heights[p] >= heights[i]:
                p = right_first_shorter[p]
            right_first_shorter[i] = p
        for i in range(len_):
            area = (right_first_shorter[i] - left_first_shorter[i] - 1)\
                * heights[i]
            max_area = max(max_area, area)
        return max_area


def main():
    test = MaximalRectangle()
    print(test.maximalRectangle(
        [['1','0','1','0','0'],
         ['1','0','1','1','1'],
         ['1','1','1','1','1'],
         ['1','0','0','1','0']]
    ))
    print(test.maximalRectangle(
        [['0']]
    ))
    print(test.maximalRectangle(
        [['1']]
    ))
    # print(test.largestRectangleinHistogram4([2, 3, 1]))

if __name__ == "__main__":
    main()
