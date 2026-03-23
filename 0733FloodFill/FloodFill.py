# -*- coding: utf-8 -*-

from typing import List

class FloodFill:
    def floodFill(self,
                  image: "List[List[int]]",
                  sr: "int",
                  sc: "int",
                  color: "int") -> "List[List[int]]":
        to_change = image[sr][sc]
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        rows = len(image)
        cols = len(image[0])
        visited = [[0] * cols for _ in range(rows)]
        print(visited)
        q = []
        q.append([sr, sc])
        visited[sr][sc] = 1
        while q:
            cur = q.pop(0)
            image[cur[0]][cur[1]] = color
            for d in dirs:
                new = [cur[0] + d[0], cur[1] + d[1]]
                if new[0] < rows and\
                new[0] >= 0 and\
                new[1] < cols and\
                new[1] >= 0 and\
                not visited[new[0]][new[1]] and\
                image[new[0]][new[1]] == to_change:
                    q.append(new[:])
                    visited[new[0]][new[1]] = 1

            for i in range(rows):
                print(image[i])
            for i in range(rows):
                print(visited[i])
            print(q)
            print('=' * 50)
        return image


def main():
    test = FloodFill()
    print(test.floodFill(
        [
            [1, 1, 1],
            [1, 1, 0],
            [1, 0, 1]
        ],
        1, 1, 2
    ))

if __name__ == "__main__":
    main()
