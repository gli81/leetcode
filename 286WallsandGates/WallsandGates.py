# -*- coding: utf-8 -*-

from typing import List

class WallsandGates:
    def wallsandGates(self, grid: "List[List[int]]") -> "None":
        """
        modify the grid, for each room cell (INF),
        calculate its dist to the closest gate

        Params:
        ----------
            grid (List[List[int]]) :

        Returns:
        ----------
            None
        """
        m = len(grid)
        if not m: return
        n = len(grid[0])
        if not n: return
        visited = [
            [False for _ in range(n)] for _ in range(m)
        ]
        q = []
        level = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == -1:
                    visited[i][j] = True
                if grid[i][j] == 0:
                    visited[i][j] = True
                    q.append((i, j))
        if not q: return

        print(visited)
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while q:
            cur_len = len(q)
            level += 1
            for _ in range(cur_len):
                (cur_i, cur_j) = q.pop(0)
                for (dx, dy) in dirs:
                    new_x, new_y = cur_i + dx, cur_j + dy
                    if 0 <= new_x < m and 0 <= new_y < n\
                    and not visited[new_x][new_y]:
                        grid[new_x][new_y] = level
                        visited[new_x][new_y] = True
                        q.append((new_x, new_y))


def main():
    test = WallsandGates()
    test1 = [
        [2147483647, -1, 0, 2147483647],
        [2147483647, 2147483647, 2147483647, -1],
        [2147483647, -1, 2147483647, -1],
        [0, -1, 2147483647, 2147483647]
    ]
    test.wallsandGates(test1)
    for r in test1: print(r)

if __name__ == "__main__":
    main()
