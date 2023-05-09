# -*- coding: utf -8-*-

from typing import List

class LargestRectangleinHistogram:
    def largestRectangleArea1(self,
                              heights: "List[int]") -> "int":
        """
        brute force solution
        over time limit
        """
        heights_set = set(heights)
        max_area = 0
        for height in heights_set:
            width = 0
            max_width = 1
            ## traverse heights
            for num in heights:
                if num >= height:
                    width += 1
                else:
                    max_width = max(max_width, width)
                    width = 0
            ## in the case 最后一个元素走了if分支没走else分支
            max_width = max(max_width, width)
            ##
            max_area = max(max_area, height * max_width)
        return max_area
    
    def largestRectangleArea4(self,
                              heights: "List[int]") -> "int":
        """
        find left less than current
        find right less than current
        (right index - left index - 1) * cur height
        """
        len_ = len(heights)
        ## right_min[i]存heights中heights[i]右边
        ## 第一个比heights[i]小的
        right_min = [-1] * len_
        left_min = [-1] * len_
        ## TODO left min
        for i in range(1, len_):
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p -= 1
            left_min[i] = p

        ## TODO right min

        max_area = 0
        for i in range(len_):
            area = (right_min[i] - left_min[i] - 1) * heights[i]
            max_area = max(area, max_area)
        return max_area


def main():
    test = LargestRectangleinHistogram()
    print(test.largestRectangleArea4([2, 1, 5, 6, 2, 3]))
    print(test.largestRectangleArea4([2, 4]))

if __name__ == "__main__":
    main()
