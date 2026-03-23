# -*- coding: utf-8 -*-

class FirstBadVersion:
    def firstBadVersion(
        self,
        n: "int",
        bad: "int"
    ) -> "int":
        l = 1
        r = n
        # if l == r: return l
        while l <= r:
            mid = (l + r) // 2
            if self.isBadVersion(mid, bad):
                if not self.isBadVersion(mid - 1, bad):
                    return mid
                else:
                    r = mid - 1
            else:
                l = mid + 1

    def isBadVersion(
        self,
        bad: "int",
        ans: "int"
    ) -> "bool":
        return True if bad == ans else False


def main():
    test = FirstBadVersion()
    print(test.firstBadVersion(5, 4))
    print(test.firstBadVersion(1, 1))
    print(test.firstBadVersion(2, 2))

if __name__ == "__main__":
    main()
