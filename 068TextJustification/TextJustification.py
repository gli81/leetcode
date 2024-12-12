# -*- coding: utf-8 -*-

from typing import List

class TextJustification:
    def fullJustify(self, words: "List[str]",
                    maxWidth: "int") -> "List[str]":
        ans = []
        cur_len = 0
        row = []
        i = 0
        while i < len(words):
            if cur_len == 0 and len(words[i]) <= maxWidth:
                row.append(words[i])
                cur_len += len(words[i])
                i += 1
            elif cur_len > 0 and\
                cur_len + 1 + len(words[i]) <= maxWidth:
                row.append(' ' + words[i])
                cur_len += 1
                cur_len += len(words[i])
                i += 1
            else:
                need_space = maxWidth - cur_len
                row = self.__insert_space(row, need_space,
                                          False)
                ans.append(''.join(row))
                row.clear()
                cur_len = 0
        ## everything left
        need_space = maxWidth - cur_len
        row = self.__insert_space(row, need_space, True)
        ans.append(''.join(row))
        return ans

    def __insert_space(self, original: "List[str]", n: "int",
                       last: "bool") -> "List[str]":
        if last:
            for _ in range(n):
                original[-1] = original[-1] + ' '
            return original
        else:
            if len(original) == 1:
                for _ in range(n):
                    original[0] = original[0] + ' '
                return original
            while n > 0:
                for i in range(len(original) - 1):
                    original[i] = original[i] + ' '
                    n -= 1
                    if n == 0: break
            return original


def main():
    test = TextJustification()
    print(test.fullJustify(
        ["This", "is", "an", "example", "of", "text",
         "justification."], 16
    ))
    print(test.fullJustify(
        ["What", "must", "be", "acknowledgment",
         "shall", "be"], 16
    ))
    print(test.fullJustify(
        ["Science", "is", "what", "we", "understand",
         "well", "enough", "to", "explain", "to", "a",
         "computer.", "Art", "is", "everything", "else",
         "we", "do"], 20
    ))


if __name__ == "__main__":
    main()
