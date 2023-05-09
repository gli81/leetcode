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
        right_min = [-1] * len(heights)
        left_min = [-1] * len(heights)
        ## TODO left min

        ## TODO right min

        max_area = 0
        for h in heights:
            area = (right_min - left_min - 1) * h
            max_area = max(area, max_area)
        return max_area


def main():
    test = LargestRectangleinHistogram()
    print(test.largestRectangleArea4([2, 1, 5, 6, 2, 3]))
    print(test.largestRectangleArea4([2, 4]))

if __name__ == "__main__":
    main()
