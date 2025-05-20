

import java.util.HashSet;
import java.util.Set;

public class GraphValidTreeJava {
    public boolean validTree(int n, int[][] edges) {
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


    public static void main(String[] args) {
        GraphValidTreeJava test = new GraphValidTreeJava();
        System.out.println(
            test.validTree(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
            })
        );
        System.out.println(
            test.validTree(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 4}
            })
        );
    }
}