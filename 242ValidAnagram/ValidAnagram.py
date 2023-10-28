# -*- coding: utf-8 -*-

class ValidAnagram:
    def isAnagram(self, s: "str", t: "str") -> "bool":
        if len(s) != len(t): return False
        len_ = len(s)
        mapp = {}
        for i in range(len_):
            mapp[s[i]] = mapp.get(s[i], 0) + 1
            mapp[t[i]] = mapp.get(t[i], 0) - 1
        for v in mapp.values():
            if v != 0: return False
        return True


def main():
    test = ValidAnagram()
    print(test.isAnagram())

if __name__ == "__main__":
    main()
