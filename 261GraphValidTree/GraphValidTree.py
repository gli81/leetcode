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


def main():
    test = GraphValidTree()
    print(test.validTree(5, [[0, 1], [0, 2], [0, 3], [1, 4]]))
    print(test.validTree(5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]))

if __name__ == "__main__":
    main()
