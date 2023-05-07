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
    
    def largestRectangleArea2(self,
                              heights: "List[int]") -> "int":
        """
        stack maybe?
        """
        pass


def main():
    test = LargestRectangleinHistogram()
    print(test.largestRectangleArea2([2, 1, 5, 6, 2, 3]))
    print(test.largestRectangleArea2([2, 4]))

if __name__ == "__main__":
    main()
