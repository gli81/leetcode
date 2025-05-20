

#include <iostream>
#include <cstdlib>
#include <vector>
using std::vector;
#include <unordered_set>
using std::unordered_set;

class GraphValidTree {
public:
    bool validTree(int n, vector<vector<int> >& edges) {
        // adj mat
        vector<vector<bool> > adj(n, vector<bool>(n, false));
        for (size_t i = 0; i < edges.size(); ++i) {
            adj[edges[i][0]][edges[i][1]] = true;
            adj[edges[i][1]][edges[i][0]] = true;
        }
        unordered_set<int> visited;
        visited.insert(0);
        // dfs
        if (!dfs(adj, visited, 0, -1)) {
            return false;
        }
        return visited.size() == n;
    }

private:
    bool dfs(
        vector<vector<bool> >& adj, unordered_set<int>& visited,
        int node, int parent
    ) {
        for (size_t i = 0; i < adj[node].size(); ++i) {
            if (adj[node][i]) {
                if (i == parent) {
                    continue;
                }
                if (visited.find(i) != visited.end()) {
                    return false;
                } else {
                    visited.insert(i);
                    if (!dfs(adj, visited, i, node)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};

int main(void) {
    std::cout << "success build" << std::endl;
    return EXIT_SUCCESS;
}