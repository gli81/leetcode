

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
}
