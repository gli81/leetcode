# -*- coding: utf-8 -*-

class ContainerwithMostWater:
    def maxArea2(self, height : list[int]) -> int:
        l = 0
        r = len(height) - 1
        ans = 0
        while l < r:
            ans = max(ans, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]: l += 1
            else: r -= 1
        return ans

def main():
    print(ContainerwithMostWater().maxArea2([1, 1]))
    print(ContainerwithMostWater().maxArea2([4, 3, 2, 1, 4]))
    print(ContainerwithMostWater().maxArea2([1,8,6,2,5,4,8,3,7]))
    print(ContainerwithMostWater().maxArea2([1, 2, 1]))

if __name__ == "__main__":
    main()
