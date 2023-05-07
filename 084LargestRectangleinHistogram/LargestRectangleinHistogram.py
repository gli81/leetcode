# -*- coding: utf -8-*-

from typing import List

class LargestRectangleinHistogram:
    def largestRectangleArea1(self, heights: "List[int]") -> "int":
        """
        brute force solution
        """
        pass


def main():
    test = LargestRectangleinHistogram()
    print(test.largestRectangleArea1([2, 1, 5, 6, 2, 3]))
    print(test.largestRectangleArea1([2, 4]))

if __name__ == "__main__":
    main()
