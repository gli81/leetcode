# -*- coding: utf-8 -*-

from typing import Optional
from collections import deque

class CloneGraph:
    def cloneGraph(
        self,
        node: "Optional[Node]"
    ) -> "Optional[Node]":
        visited = {}
        if not node: return None
        q = deque([node])
        visited[node.val] = Node(node.val, [])
        while q:
            n = q.popleft()
            for neighbor in n.neighbors:
                if neighbor.val not in visited:
                    visited[neighbor.val] = Node(
                        neighbor.val, []
                    )
                    q.append(neighbor)
                visited[n.val].neighbors.append(visited[neighbor.val])
        return visited[node.val]


def main():
    test = CloneGraph()


class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
