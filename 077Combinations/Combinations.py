# -*- coding: utf -8-*-

from typing import List

class Combinations:
    def combine1(self, n: "int", k: "int"):
        ans = []
        self.__get_ans2(n, k, ans, [], 1)
        return ans

    def __get_ans(self, n: "int", k: "int",
                  ans: "List[List[int]]", cur: "List[int]",
                  start: "int") -> "None":
        if len(cur) == k:
            ans.append(cur[:])
            return
        for i in range(start, n + 1):
            cur.append(i)
            self.__get_ans(n, k, ans, cur, i + 1)
            cur.pop()


def main():
    test = Combinations()
    print(test.combine1(4, 2))
    print(test.combine1(1, 1))

if __name__ == "__main__":
    main()
