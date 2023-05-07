# -*- coding: utf -8-*-

from typing import List

class LargestRectangleinHistogram:
    def largestRectangleArea1(self, heights: "List[int]") -> "int":
        """
        brute force solution
        over time limit
        """
        heights_set = set(heights)
        max_area = 0
        for ele in heights_set:
            print(ele)
            


def main():
    test = LargestRectangleinHistogram()
    print(test.largestRectangleArea1([2, 1, 5, 6, 2, 3]))
    print(test.largestRectangleArea1([2, 4]))

if __name__ == "__main__":
    main()
