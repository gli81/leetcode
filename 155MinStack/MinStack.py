# -*- coding: utf-8 -*-

from typing import Optional

class MinStack:
    def __init__(self):
        self.stk = []
        self.minStk = []

    def push(self, val: int) -> None:
        self.stk.append(val)
        if len(self.minStk) > 0:
            min_ = min(val, self.minStk[-1])
            self.minStk.append(min_)
        else: ## empty stk
            self.minStk.append(val)

    def pop(self) -> None:
        self.stk.pop()
        self.minStk.pop()

    def top(self) -> Optional[int]:
        return self.stk[-1] if len(self.stk) > 0 else None

    def getMin(self) -> Optional[int]:
        return self.minStk[-1] if len(self.minStk) > 0 else None


def main():
    test = MinStack()

if __name__ == "__main__":
    main()
