# -*- coding: utf-8 -*-
class LongestPalindromicSubstring1():
    def longestPalindrome(self, s : str) -> str:
        def palindromeCenteredAt(s : str, leftIndex : int, rightIndex : int) -> int:
            '''
            returns the length of longest panlindrome around
            the one or two letter long substring of s from index leftIndex to rightIndex
            '''
            left = leftIndex
            right = rightIndex
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return right - left - 2 + 1
        end = start = 0
        for i in range(len(s)):
            len1 = palindromeCenteredAt(s, i, i)
            len2 = palindromeCenteredAt(s, i, i + 1)
            length = max(len1, len2)
            ## if find a longer palindrome, update start and end
            if length > (end - start + 1):
                start = i - (length - 1)// 2
                end = i + length // 2
        return s[start:end + 1]




def main():
    s = "liguangzhengne"
    print(LongestPalindromicSubstring1().longestPalindrome(s))

if __name__ == '__main__':
    main()