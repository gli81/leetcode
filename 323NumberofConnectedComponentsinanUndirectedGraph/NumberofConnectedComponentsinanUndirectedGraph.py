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


def main():
    test = NumberofConnectedComponentsinanUndirectedGraph()
    print(test.countComponents1(3, [[0, 1], [0, 2]]))
    print(test.countComponents1(5, [[0, 1], [1, 2], [3, 4]]))
    print(test.countComponents1(6, [[0, 1], [1, 2], [2, 3], [4, 5]]))

if __name__ == "__main__":
    main()
