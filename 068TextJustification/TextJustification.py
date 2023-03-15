# -*- coding: utf-8 -*-

from typing import List

class TextJustification:
    def fullJustify(self, s: "List[str]",
                    idth: "int") -> "List[str]":
        pass
        

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
