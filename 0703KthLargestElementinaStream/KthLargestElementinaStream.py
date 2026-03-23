# -*- coding: utf-8 -*-

from typing import List
import heapq

class KthLargestElementinaStream:
    def __init__(self, k: "int", nums: "List[int]"):
        self.__k = k
        self.__pq = nums
        heapq.heapify(self.__pq)
        while len(self.__pq) > self.__k:
            heapq.heappop(self.__pq)

    def add(self, val: "int") -> "int":
        if len(self.__pq) < self.__k or\
                (len(self.__pq) > 0 and self.__pq[0] < val):
            heapq.heappush(self.__pq, val)
            if len(self.__pq) > self.__k:
                heapq.heappop(self.__pq)
        return self.__pq[0]

    def __str__(self):
        return str(self.__pq)


def main():
    test1 = KthLargestElementinaStream(2, [0])
    print(test1)
    print(test1.add(-1))
    print(test1)

if __name__ == "__main__":
    main()
