# -*- coding: utf-8 -*-

from typing import List

class KokoEatingBananas:
    def minEatingSpeed(
        self,
        piles: "List[int]",
        h: "int"
    ) -> "int":
        """
        binary search on the range
        """
        l, r = 1, max(piles)
        ans = r
        while l <= r:
            k = l + (r - l) // 2
            time = 0
            for pile in piles:
                time += pile // k + int(pile % k != 0)
                if time > h: break
            if time > h:
                ## increase k
                l = k + 1
            else:
                ans = k
                r = k - 1
        return ans


def main():
    test = KokoEatingBananas()
    print(test.minEatingSpeed(
        [1, 4, 3, 2], 9
    ))
    print(test.minEatingSpeed(
        [25, 10, 23, 4], 4
    ))

if __name__ == "__main__":
    main()
