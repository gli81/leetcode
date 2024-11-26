# -*- coding: utf-8 -*-

from typing import List

class MaxAreaofIsland:
    def maxAreaofIsland(self, grid: "List[List[int]]") -> "int":
        m = len(grid)
        if not m: return 0
        n = len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not visited[i][j]:
                    area = 1 ## found America! call me Columbus
                    q = [(i, j)]
                    visited[i][j] = True
                    ## bfs
                    while q:
                        x, y = q.pop(0)
                        for dx, dy in dirs:
                            nx, ny = x + dx, y + dy
                            if 0 <= nx < m and 0 <= ny < n and\
                                    not visited[nx][ny] and grid[nx][ny] == 1:
                                area += 1
                                visited[nx][ny] = True
                                q.append((nx, ny))
                    ans = max(ans, area)
        return ans


def main():
    test = MaxAreaofIsland()
    print(
        test.maxAreaofIsland(
            [
                [0, 1, 1, 0, 1],
                [1, 0, 1, 0, 1],
                [0, 1, 1, 0, 1],
                [0, 1, 0, 0, 1],
            ]
        )
    )

if __name__ == "__main__":
    main()