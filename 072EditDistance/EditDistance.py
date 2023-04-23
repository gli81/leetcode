# -*- coding: utf -8-*-

class EditDistance:
    def minDistance1(self, word1: "str", word2: "str") -> "int":
        pass

    def minDistance2(self, word1: "str", word2: "str") -> "int":
        pass

    def __helper(self, word1: "str", word2: "str",
                d: "Dict" = {}) -> "int":
        pass


def main():
    test = EditDistance()
    print(test.minDistance2("horse", "ros"))
    print(test.minDistance2("intention", "execution"))

if __name__ == "__main__":
    main()
