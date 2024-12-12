# -*- coding: utf-8 -*-

import bisect

## 实在参不透这题的意义
## 直接抄了个题解，Java的也懒得写了
class TimeBasedKeyValueStore:
    def __init__(self):
        self.map = {}

    def set(
        self,
        key: "str",
        value: "str",
        timestamp: "int"
    ) -> "None":
        if key not in self.map:
            self.map[key] = [[], []]
        self.map[key][0].append(timestamp)
        self.map[key][1].append(value)

    def get(
        self,
        key: "str",
        timestamp: "int"
    ) -> "str":
        if key not in self.map:
            return ''
        time_infos = self.map[key][0]
        value_infos = self.map[key][1]
        idx = bisect.bisect(time_infos, timestamp) - 1
        return value_infos[idx] if idx >= 0 else ''


def main():
    test = TimeBasedKeyValueStore()
    test.set("foo", "bar", 1)
    test.set("foo", "barr", 2)
    print(test.get("foo", 1))
    print(test.get("foo", 3))
