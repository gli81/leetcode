# -*- coding: utf-8 -*-

from typing import List, Set

class GraphValidTree:
    def validTree(self, n: "int", edges: "List[List[int]]") -> "bool":
        ## create adjancency list
        adj = [[False for _ in range(n)] for _ in range(n)]
        for [a, b] in edges:
            adj[a][b] = True
            adj[b][a] = True
        visited = set()
        visited.add(0)
        ## dfs
        if not self.__dfs(adj, visited, 0, -1):
            ## there is a cycle
            return False
        ## no cycle, if all connected
        return len(visited) == n

    def __dfs(
        self, adj: "List[List[bool]]",
        visited: "Set[int]", node: "int", prev: "int"
    ) -> "bool":
        for i in range(len(adj[node])):
            ## for each neighbor
            if adj[node][i]:
                if i == prev:
                    ## don't go back to where it comes from
                    continue
                if i in visited:
                    ## cycle detected
                    return False
                visited.add(i)
                if not self.__dfs(adj, visited, i, node):
                    return False
        return True

    def validTree3(self, n: "int", edges: "List[List[int]]") -> "bool":
        dsu = DSU(n)
        for [src, dst] in edges:
            if not dsu.union(src, dst):
                return False ## cycle detected
        return dsu.getParts() == 1


class DSU:
    def __init__(self, n: "int"):
        self.parents = [i for i in range(n)]
        self.heights = [1 for _ in range(n)]
        self.parts = n

    def find(self, node: "int") -> "int":
        if self.parents[node] != node:
            self.parents[node] = self.find(self.parents[node])
        return self.parents[node]

    def union(self, a: "int", b: "int") -> "bool":
        ra = self.find(a)
        rb = self.find(b)
        if ra == rb:
            return False
        if self.heights[ra] < self.heights[rb]:
            self.parents[ra] = rb
        elif self.heights[ra] > self.heights[rb]:
            self.parents[rb] = ra
        else:
            self.parents[rb] = ra
            self.heights[ra] += 1
        self.parts -= 1
        return True

    def getParts(self) -> "int":
        return self.parts


def main():
    test = GraphValidTree()
    print(test.validTree3(5, [[0, 1], [0, 2], [0, 3], [1, 4]]))
    print(test.validTree3(5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]))

if __name__ == "__main__":
    main()
