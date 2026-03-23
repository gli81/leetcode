# -*- coding: utf -8-*-

import sys

class MinWindowSubstring:
    def minWindow(self, s: "str", t: "str") -> "str":
        left = right = ans_left = 0
        ans_right = -1
        ans_len = sys.maxsize
        arr = [0] * 128
        for letter in t:
            arr[ord(letter)] += 1
        count = len(t)
        while right < len(s):
            arr[ord(s[right])] -= 1
            if arr[ord(s[right])] >= 0: count -= 1
            while count == 0:
                temp_len = right - left + 1
                if temp_len < ans_len:
                    ans_len = temp_len
                    ans_left = left
                    ans_right = right
                arr[ord(s[left])] += 1
                if arr[ord(s[left])] > 0: count += 1
                left += 1
            right += 1
        # print(ans_left, ans_right)
        return s[ans_left:ans_right + 1]


def main():
    test = MinWindowSubstring()
    print(test.minWindow("ADOBECODEBANC", "ABC"))
    print(test.minWindow("a", "a"))
    print(test.minWindow("a", "aa"))

if __name__ == "__main__":
    main()
