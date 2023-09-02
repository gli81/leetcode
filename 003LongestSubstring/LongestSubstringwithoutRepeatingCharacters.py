class LongestSubstringwithoutRepeatingCharacters:
    def lengthOfLongestSubstring4(self,
                                 s : "str") -> "int":
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


def main():
    test = LongestSubstringwithoutRepeatingCharacters()
    print(test.lengthOfLongestSubstring4("abcabcbb"))

if __name__ == "__main__":
    main()
