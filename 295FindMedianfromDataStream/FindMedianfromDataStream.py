# -*- coding: utf-8 -*-

import heapq

class FindMedianfromDataStream:
    def __init__(self):
        self.smallHeap = [] ## actually max heap
        self.largeHeap = [] ## actually min heap

    def addNum(self, num: "int") -> "None":
        if self.smallHeap and -num < self.smallHeap[0]:
            heapq.heappush(self.largeHeap, num)
        else:
            heapq.heappush(self.smallHeap, -num)
        while len(self.smallHeap) > len(self.largeHeap) + 1:
            heapq.heappush(self.largeHeap, -heapq.heappop(self.smallHeap))
        while len(self.largeHeap) > len(self.smallHeap):
            heapq.heappush(self.smallHeap, -heapq.heappop(self.largeHeap))

    def findMedian(self) -> "float":
        return -self.smallHeap[0] if \
            len(self.smallHeap) > len(self.largeHeap) else \
            (-self.smallHeap[0] + self.largeHeap[0]) / 2.0


def main():
    test = FindMedianfromDataStream()
    test.addNum(1)
    print(test.findMedian())
    test.addNum(2)
    print(test.findMedian())
    test.addNum(3)
    print(test.smallHeap)
    print(test.largeHeap)
    print(test.findMedian())
    print("===== test2 =====")
    test2 = FindMedianfromDataStream()
    test2.addNum(5)
    test2.addNum(3)
    print(test2.smallHeap)
    print(test2.largeHeap)
    print(test2.findMedian())
    test2.addNum(7)
    print(test2.findMedian())
    test2.addNum(2)
    print(test2.smallHeap)
    print(test2.largeHeap)
    print(test2.findMedian())

if __name__ == "__main__":
    main()
