# -*- coding: utf-8 -*-

from typing import List, Set

class NumberofConnectedComponentsinanUndirectedGraph:
    def countComponents1(self, n: "int", edges: "List[List[int]]") -> "int":
        ## create adj mat
        adj = [[False for _ in range(n)] for _ in range(n)]
        for [a, b] in edges:
            adj[a][b] = True
            adj[b][a] = True
        visited = set()
        ans = 0
        for i in range(n):
            if i not in visited: ## found a new component
                ans += 1 ## increment ans
                ## mark all connected nodes as visted
                self.__dfs(adj, visited, i)
        return ans

    def __dfs(
        self, adj: "List[List[bool]]", visited: "Set[int]", node : "int"
    ) -> "None":
        visited.add(node)
        for i in range(len(adj)):
            if adj[node][i] and i not in visited:
                visited.add(i)
                self.__dfs(adj,visited, i)

    def countComponents3(self, n: "int", edges: "List[List[int]]") -> "int":
        dsu = DSU(n)
        for [a, b] in edges:
            dsu.union(a, b)
        return dsu.getParts()


class DSU:
    def __init__(self, n: "int"):
        self.__parents = [i for i in range(n)]
        self.__heights = [1 for _ in range(n)]
        self.__parts = n

    def union(self, a: "int", b: "int") -> "None":
        ra = self.__find(a)
        rb = self.__find(b)
        if ra != rb:
            if self.__heights[ra] < self.__heights[rb]:
                self.__parents[ra] = rb
            elif self.__heights[ra] > self.__heights[rb]:
                self.__parents[rb] = ra
            else:
                self.__parents[rb] = ra
                self.__heights[ra] += 1
            self.__parts -= 1

    def __find(self, n: "int") -> "int":
        """
        Find the root of a given node
        """
        if self.__parents[n] != n:
            self.__parents[n] = self.__find(self.__parents[n])
        return self.__parents[n]

    def getParts(self) -> "int":
        return self.__parts


def main():
    test = NumberofConnectedComponentsinanUndirectedGraph()
    print(test.countComponents3(3, [[0, 1], [0, 2]]))
    print(test.countComponents3(5, [[0, 1], [1, 2], [3, 4]]))
    print(test.countComponents3(6, [[0, 1], [1, 2], [2, 3], [4, 5]]))

if __name__ == "__main__":
    main()
