class LongestSubstring4:
    def longestSubstring(self, s : str) -> int:
        index = [0] * 128
        n = len(s)
        ans = 0
        i = 0
        j = 0
        while j < n:
            i = max(i, index[ord(s[j])])
            ans = max(ans, j - i + 1)
            index[ord(s[j])] = j + 1
            j += 1
        return ans
print(LongestSubstring4().longestSubstring("abcabcbb"))
