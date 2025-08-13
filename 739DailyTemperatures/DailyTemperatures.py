# -*- coding: utf-8 -*-

from typing import List

class DailyTemperatures:
    def dailyTemperatures(
        self, temperatures: "List[int]"
    ) -> "List[int]":
        n = len(temperatures)
        ans = [0] * n
        stk = []
        stk.append(0)
        for i in range(1, n):
            while stk and \
            temperatures[stk[-1]] < temperatures[i]: ## warmer day found
                ## pop all the days that are cooler one by one
                poped = stk.pop()
                ## and calculate the days btwn
                ans[poped] = i - poped
            stk.append(i)
        return ans


def main():
    test = DailyTemperatures()
    print(
        test.dailyTemperatures(
            [73, 74, 75, 71, 69, 72, 76, 73]
        )
    )

if __name__ == "__main__":
    main()
