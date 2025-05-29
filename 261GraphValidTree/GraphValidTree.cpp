

#include <iostream>
#include <cstdlib>
#include <vector>
using std::vector;
#include <unordered_set>
using std::unordered_set;

class DSU {
    int parts;
    vector<int> parents;
    vector<int> heights;


public:
    DSU(int n): parts(n), parents(vector<int>(n)), heights(vector<int>(n, 1)) {
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
    }


    int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    bool union_(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) {
            return false; // cycle detected
        }
        if (heights[ra] < heights[rb]) {
            parents[ra] = rb;
        } else if (heights[ra] > heights[rb]) {
            parents[rb] = ra;
        } else {
            parents[rb] = ra;
            heights[ra]++;
        }
        parts--;
        return true;
    }

    int getParts() const {
        return parts;
    }
};


class GraphValidTree {
public:
    bool validTree1(int n, vector<vector<int> >& edges) {
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

    bool validTree3(int n, vector<vector<int> >& edges) {
        DSU dsu(n);
        for (size_t i = 0; i < edges.size(); ++i) {
            if (!dsu.union_(edges[i][0], edges[i][1])) {
                return false; // cycle detected
            }
        }
        return dsu.getParts() == 1;
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