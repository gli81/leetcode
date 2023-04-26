# -*- coding: utf -8-*-

from typing import List

class WordSearch:
    def exist(self, board: "List[List[str]]",
              word: "str") -> "bool":
        '''
        over time limit, fuck it
        '''
        rows = len(board)
        if not rows: return False
        cols = len(board[0])
        used = [[False] * cols for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if self.__exist_(board, word, i, j,
                                 0, used): return True
        return False

    def __exist_(self, board: "List[List[str]]", word: "str",
                 row: "int", col: "int", index: "int",
                 used: "List[List[bool]]") -> "bool":
        ## out of bound
        if row not in range(0, len(board)) or\
              col not in range(0, len(board[0])): return False
        ## used
        if used[row][col]: return False
        ## not what we are looking for
        if board[row][col] != word[index]: return False
        ## found the entire thing
        if index == len(word) - 1: return True
        used[row][col] = True
        ## try four directions
        ## up
        if self.__exist_(board, word, row - 1, col,
                         index + 1, used): return True
        ## down
        if self.__exist_(board, word, row + 1, col,
                         index + 1, used): return True
        ## left
        if self.__exist_(board, word, row, col - 1,
                         index + 1, used): return True
        ## right
        if self.__exist_(board, word, row, col + 1,
                         index + 1, used): return True
        ## nothing works
        used[row][col] = False
        return False


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
