# -*- coding: utf -8-*-

class ScrambleString:
    def isScramble(self, s1: "str", s2: "str") -> "bool":
        pass


def main():
    test = ScrambleString()
    print(test.isScramble("great", "rgeat"))
    print(test.isScramble("abcde", "caebd"))
    print(test.isScramble('a', 'a'))

if __name__ == "__main__":
    main()
