

import java.util.Set;

public class NumberofConnectedComponentsinanUndirectedGraphJava {
    public int countComponents1(int n, int[][] edges) {
        boolean[][] adj = new boolean[n][n];
        for (int[] e : edges) {
            adj[e[0]][e[1]] = true;
            adj[e[1]][e[0]] = true;
        }
        int ans = 0;
        Set<Integer> visited = new java.util.HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (!visited.contains(i)) {
                ans++;
                dfs(adj, visited, i);
            }
        }
        return ans;
    }

    private void dfs(boolean[][] edges, Set<Integer> visited, int node) {
        visited.add(node);
        for (int i = 0; i < edges.length; ++i) {
            if (edges[node][i] && !visited.contains(i)) {
                visited.add(i);
                dfs(edges, visited, i);
            }
        }
    }

    public int countComponents3(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }
        return dsu.getParts();
    }
}


class DSU {
    private int[] parent;
    private int[] heights;
    private int count;


    public DSU(int n) {
        this.parent = new int[n];
        this.heights = new int[n];
        this.count = n;
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            heights[i] = 1;
        }
    }


    private int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            if (heights[ra] < heights[rb]) {
                parent[ra] = rb;
            } else if (heights[ra] > heights[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                heights[ra]++;
            }
            this.count--;
        }
    }

    public int getParts() {
        return count;
    }
}
