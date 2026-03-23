# -*- coding: utf-8 -*-

from typing import List

class Minesweeper:
    def __init__(self):
        self.__dir_x = [-1, 0, 1, -1, 1, -1, 0, 1]
        self.__dir_y = [-1, -1, -1, 0, 0, 1, 1, 1]


    def updateBoard(
        self, board: List[List[str]], click: List[int]
    ) -> List[List[str]]:
        if not board:
            return board
        x, y = click
        ## mine
        if board[x][y] == 'M':
            board[x][y] = 'X'
        else:
            self.__dfs(board, x, y) ## update blank and number
        return board

    def __dfs(self, board: List[List[str]], x: int, y: int) -> None:
        lenx = len(board)
        leny = len(board[0])
        ct = 0
        ## decide num or blank & recurse
        for i in range(8):
            dx, dy = x + self.__dir_x[i], y + self.__dir_y[i]
            if 0 <= dx < lenx and 0 <= dy < leny and board[dx][dy] == 'M':
                ## no X cuz X means game over and you won't get here
                ct += 1
        if ct > 0:
            ## number, no recursion
            board[x][y] = str(ct)
        else:
            ## blank, recursion
            board[x][y] = 'B'
            for i in range(8):
                dx, dy = x + self.__dir_x[i], y + self.__dir_y[i]
                if 0 <= dx < lenx and 0 <= dy < leny and board[dx][dy] == 'E':
                    self.__dfs(board, dx, dy)