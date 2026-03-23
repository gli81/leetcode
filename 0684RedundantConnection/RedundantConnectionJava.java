

import java.util.ArrayList;
import java.util.List;

public class RedundantConnectionJava {
    public int[] findRedundantConnection1(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            // check for cycle after adding each node
            boolean[] visited = new boolean[n + 1];
            if (dfs(a, -1, visited, adj)) return edge;
        }
        return new int[0];
    }

    private boolean dfs(
        int node, int parent,
        boolean[] visited, List<List<Integer>> adj
    ) {
        if (visited[node]) return true;
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) continue;
            if (dfs(nei, node, visited, adj)) return true;
        }
        return false;
    }

    public int[] findRedundantConnection2(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                return edge; // they already connected before this edge, cycle
            }
        }
        return new int[0];
    }
}


class DSU {
    private int[] parents;
    private int[] heights;


    public DSU(int n) {
        this.parents = new int[n];
        this.heights = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
            heights[i] = 1;
        }
    }


    public boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return true; // already connected
        if (heights[ra] < heights[rb]) {
            parents[ra] = rb;
        } else if (heights[ra] > heights[rb]) {
            parents[rb] = ra;
        } else {
            parents[rb] = ra;
            heights[ra]++;
        }
        return false;
    }

    private int find(int n) {
        if (parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }
}
