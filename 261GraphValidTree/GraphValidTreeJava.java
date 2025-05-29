

import java.util.HashSet;
import java.util.Set;

public class GraphValidTreeJava {
    public boolean validTree1(int n, int[][] edges) {
        // adj mat
        boolean[][] adj = new boolean[n][n];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = true;
            adj[edge[1]][edge[0]] = true;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        if (!dfs(adj, visited, 0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean dfs(boolean[][] adj, Set<Integer> visited, int node, int prev) {
        for (int i = 0; i < adj[node].length; ++i) {
            if (adj[node][i]) {
                // there is an edge
                if (i == prev) {
                    continue;
                }
                if (visited.contains(i)) {
                    return false;
                }
                visited.add(i);
                if (!dfs(adj, visited, i, node)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validTree3(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.getParts() == 1;
    }


    public static void main(String[] args) {
        GraphValidTreeJava test = new GraphValidTreeJava();
        System.out.println(
            test.validTree3(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
            })
        );
        System.out.println(
            test.validTree3(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 4}
            })
        );
    }
}

class DSU {
    private int parts;
    private int[] parents;
    private int[] heights;


    public DSU(int n) {
        this.parts = n;
        this.parents = new int[n];
        this.heights = new int[n];
        for (int i = 0; i < n; ++i) {
            this.parents[i] = i;
            this.heights[i] = 1;
        }
    }


    public int find(int node) {
        if (this.parents[node] != node) {
            // update the parent in case of previous union
            // only if not separate node
            this.parents[node] = find(this.parents[node]);
        }
        return this.parents[node];
    }

    public boolean union(int a, int b) {
        int ra = find(a); int rb = find(b);
        if (ra == rb) {
            return false; // loop detected
        }
        if (this.heights[ra] < this.heights[rb]) {
            this.parents[ra] = rb;
        } else if (this.heights[ra] > this.heights[rb]) {
            this.parents[rb] = ra;
        } else {
            // equal heights
            this.parents[rb] = ra;
            this.heights[ra]++;
        }
        this.parts--;
        return true;
    }

    public int getParts() {
        return this.parts;
    }
}
