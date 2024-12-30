# -*- coding: utf-8 -*-

from typing import List

class PacificAtlanticWaterFlow:
    def pacificAtlantic(
        self, heights: "List[List[int]]"
    ) -> "List[List[int]]":
        ans = []
        m = len(heights)
        if not m: return ans
        n = len(heights[0])
        if not n: return ans
        atl = [[False for _ in range(n)] for _ in range(m)]
        pac = [[False for _ in range(n)] for _ in range(m)]
        aq = []
        pq = []
        for i in range(m):
            aq.append((i, n-1))
            pq.append((i, 0))
        for j in range(n):
            aq.append((m-1, j))
            pq.append((0, j))
        dirs = [(1, 0), (-1, 0), (0, -1), (0, 1)]
        while aq:
            cur_x, cur_y = aq.pop()
            atl[cur_x][cur_y] = True
            for dx, dy in dirs:
                new_x, new_y = cur_x + dx, cur_y + dy
                if (
                    0 <= new_x < m and 0 <= new_y < n
                    and not atl[new_x][new_y]
                    and heights[new_x][new_y] >= heights[cur_x][cur_y]
                ):
                    aq.append((new_x, new_y))
        while pq:
            cur_x, cur_y = pq.pop()
            pac[cur_x][cur_y] = True
            for dx, dy in dirs:
                new_x, new_y = cur_x + dx, cur_y + dy
                if (
                    0 <= new_x < m and 0 <= new_y < n
                    and not pac[new_x][new_y]
                    and heights[new_x][new_y] >= heights[cur_x][cur_y]
                ):
                    pq.append((new_x, new_y))
        for i in range(m):
            for j in range(n):
                if atl[i][j] and pac[i][j]:
                    ans.append([i, j])
        return ans


def main():
    test = PacificAtlanticWaterFlow()

if __name__ == "__main__":
    main()
