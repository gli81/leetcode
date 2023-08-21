# -*- coding: utf-8 -*-

from typing import List

class GasStation:
    def canCompleteCircuit(self, gas: "List[int]",
                           cost: "List[int]") -> "int":
        i = 0
        while i < len(gas):
            tank = gas[i]
            for j in range(1, len(gas) + 1):
                cur = (i + j) % len(gas)
                cur_1 = (i + j - 1) % len(gas)
                tank -= cost[cur_1]
                if tank < 0:
                    if cur_1 < i:
                        return -1
                    i = cur_1
                    break
                if j == len(gas):
                    return i
                tank += gas[cur]
            i += 1
        return -1