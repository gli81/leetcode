# -*- coding: utf-8 -*-

from typing import List, Dict

class UniquePathsII:
    def uniquePathsWithObstacles(self,
                    obstacleGrid: "List[List[int]]") -> "int":
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1: return 0
        # if obstacleGrid[m - 1][n - 1] == 1: return 0
        visited = {}
        return self.__get_ans(0, 0, m - 1, n - 1,
                              visited, obstacleGrid)
    
    def __get_ans(self, x: "int", y: "int", m: "int", n: "int",
                  visited: "Dict[str, int]",
                  obstacleGrid: "List[List[int]]") -> "int":
        if x == m and y == n: return 1
        n1 = n2 = 0
        key: "str" = str(x + 1) + "@" + str(y)
        if key in visited: n1 = visited[key]
        else:
            if x + 1 <= m and obstacleGrid[x + 1][y] == 0:
                n1 = self.__get_ans(x + 1, y, m, n,
                                    visited, obstacleGrid)
        key = str(x) + '@' + str(y + 1)
        if key in visited: n2 = visited[key]
        else:
            if y + 1 <= n and obstacleGrid[x][y + 1] == 0:
                n2 = self.__get_ans(x, y + 1, m, n,
                                    visited, obstacleGrid)
        ## put (x, y) in the map
        key = str(x) + "@" + str(y)
        visited[key] = n1+n2
        return n1 + n2
        


def main():
    test = UniquePathsII()
    print(test.uniquePathsWithObstacles([[0, 0, 0],
                                         [0, 1, 0],
                                         [0, 0, 0]]))
    print(test.uniquePathsWithObstacles([[0, 1],
                                         [0, 0]]))
    print(test.uniquePathsWithObstacles([[0, 1]]))


if __name__ == "__main__":
    main()
