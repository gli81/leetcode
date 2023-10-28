# -*- coding: utf-8 -*-

class LongestRepeatingCharacterReplacement:
    def characterReplacement_brute_force(
            self,
            s: "str",
            k: "int"
    ) -> "int":
        ## all substrings
        ans = 0
        for i in range(len(s) - 1):
            for j in range(i + 2, len(s) + 1):
                freq = [0] * 26
                # print(s[i:j])
                word = s[i : j]
                for char in word:
                    # print(ord(char))
                    freq[ord(char) - ord('A')] += 1
                max_v = max(freq)
                if max_v + k >= len(word):
                    ans = max(len(word), ans)                
        return ans

    def characterReplacement(
            self,
            s: "str",
            k: "int"
    ) -> "int":
        len_ = len(s)
        if len_ < 2: return len_
        minus = ord('A')
        l, r = 0, 0
        ans = 0
        max_count = 0
        freq = [0] * 26
        while r < len_:
            freq[ord(s[r]) - minus] += 1
            max_count = max(
                max_count, freq[ord(s[r]) - minus]
            )
            r += 1
            ## 如果当前窗口凑不成完全一样的字符串
            ## 从左边移除
            if max_count + k + l - r < 0:
                freq[ord(s[l]) - minus] -= 1
                l += 1
            ans = max(ans, r - l)
        return ans


def main():
    test = LongestRepeatingCharacterReplacement()
    print(test.characterReplacement("ABAB", 2))
    print(test.characterReplacement("AABABBA", 1))

if __name__ == "__main__":
    main()
