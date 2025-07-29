# -*- coding: utf-8 -*-

from typing import List

class RedundantConnection:
    def findRedundantConnection1(self, edges: "List[List[int]]") -> "List[int]":
        '''
        cycle detection
        '''
        n = len(edges)
        ## create adj mat
        adj = [[] for _ in range(n + 1)]
        for [a, b] in edges:
            ## add edge one by one
            adj[a].append(b)
            adj[b].append(a)
            ## after adding each edge, check for cycle
            ## guarentees that the last edge of the cycle is found
            ## cuz earlier edges in the cycle didn't form the cycle
            ## until the last edge added
            visited = [False for _ in range(n + 1)]
            if self.__dfs(a, -1, visited, adj):
                return [a, b]
        return []

    def __dfs(
        self, node: "int", p: "int",
        visited: "List[bool]", adj: "List[List[int]]"
    ) -> "bool":
        if visited[node]: return True
        visited[node] = True
        for nei in adj[node]:
            if nei == p: continue
            if (self.__dfs(nei, node, visited, adj)): return True
        return False

    def findRedundantConnection2(self, edges: "List[List[int]]") -> "List[int]":
        '''
        disjoint set union
        '''
        n = len(edges)
        dsu = DSU(n + 1)
        for [a, b] in edges:
            if dsu.union(a, b):
                return [a, b] ## they already connected before this edge, cycle
        return []

    def findRedundantConnection3(self, edges: "List[List[int]]") -> "List[int]":
        return []


class DSU:
    def __init__(self, n: "int"):
        self.__parents = [i for i in range(n + 1)]
        self.__heights = [1 for _ in range(n + 1)]

    def union(self, a: "int", b: "int") -> "bool":
        ra = self.__find(a)
        rb = self.__find(b)
        if ra == rb: return True ## already connected
        if self.__heights[ra] < self.__heights[rb]:
            self.__parents[ra] = rb
        elif self.__heights[ra] > self.__heights[rb]:
            self.__parents[rb] = ra
        else:
            self.__parents[rb] = ra
            self.__heights[ra] += 1
        return False

    def __find(self, n: "int") -> "int":
        if self.__parents[n] != n:
            self.__parents[n] = self.__find(self.__parents[n])
        return self.__parents[n]

def main():
    test = RedundantConnection()

if __name__ == "__main__":
    main()
