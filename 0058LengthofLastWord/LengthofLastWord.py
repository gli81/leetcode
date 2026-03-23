# -*- coding: utf-8 -*-

class LengthofLastWord():
    def lengthOfLastWord(self, s: "str") -> "int":
        s = s.strip()
        ans = 0
        for i in range(len(s)):
            if s[len(s) - i - 1] != ' ':
                ans += 1
            else:
                return ans
        return ans

def main():
    test = LengthofLastWord()
    print(test.lengthOfLastWord("Hello World"))
    print(test.lengthOfLastWord("   fly me   to   the moon  "))
    print(test.lengthOfLastWord("luffy is still joyboy"))

if __name__ == "__main__":
    main()
