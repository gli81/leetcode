# -*- coding: utf-8 -*-

from typing import List

class RottingOranges:
    def orangesRotting(
        self,
        grid: "List[List[int]]"
    ) -> "int":
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        rows = len(grid)
        if not rows: return -1
        cols = len(grid[0])
        q = []
        steps = {}
        ## 用来记录第value个时间点时
        ## 第key个orange被rot
        cnt = 0
        for r in range(rows):
            for c in range(cols):
                ind = r * cols + c
                if grid[r][c] == 2:
                    q.append(ind)
                    steps[ind] = 0
                elif grid[r][c] == 1:
                    cnt += 1
        ans = 0
        while q:
            cur = q.pop(0)
            r_ = cur // cols
            c_ = cur % cols
            for r, c in dirs:
                new_r = r_ + r
                new_c = c_ + c
                if 0 <= new_r < rows \
                and 0 <= new_c < cols \
                and grid[new_r][new_c] == 1:
                    new_ind = new_r * cols + new_c
                    cnt -= 1
                    grid[new_r][new_c] = 2
                    q.append(new_ind)
                    steps[new_ind] = steps[cur] + 1
                    ans = max(ans, steps[new_ind])
        return -1 if cnt else ans


def main():
    test = RottingOranges()
    print(test.orangesRotting(
        [[2, 1, 1],
        [1, 1, 0],
        [0, 1, 1]]
    ))

if __name__ == "__main__":
    main()
