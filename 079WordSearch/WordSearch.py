

from typing import List

class WordSearch:
    def exist(self, board: "List[List[str]]", word: "str") -> "bool":
        pass


def main():
    test = WordSearch()
    print(test.exist([
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ], "ABCCED"))
    print(test.exist([
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ], "SEE"))
    print(test.exist([
        ['A', 'B', 'C', 'E'],
        ['S', 'F', 'C', 'S'],
        ['A', 'D', 'E', 'E']
    ], "ABCB"))

if __name__ == "__main__":
    main()
