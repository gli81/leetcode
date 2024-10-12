# -*- coding: utf-8 -*-

from typing import List
import heapq

class TaskScheduler:
    def leastInterval(self, tasks: "List[str]", n: "int") -> "int":
        ct = {}
        for task in tasks:
            ct[task] = ct.get(task, 0) + 1
        pq = [-num for num in ct.values()]
        heapq.heapify(pq)
        q = []
        time = 0
        while len(pq) != 0 or len(q) != 0:
            if len(q) != 0 and q[0][1] <= time:
                heapq.heappush(pq, -q.pop(0)[0])
            if len(pq) != 0:
                cur = heapq.heappop(pq) + 1
                q.append([cur, time + n + 1])
            time += 1
        return time


def main():
    test = TaskScheduler()
    print(test.leastInterval(['A', 'B', 'A', 'A', 'B', 'B'], 2))

if __name__ == "__main__":
    main()
