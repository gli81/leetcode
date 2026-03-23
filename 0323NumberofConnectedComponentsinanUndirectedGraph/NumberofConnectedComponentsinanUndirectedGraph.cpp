
#include <iostream>
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

    void union_(int a, int b) {
        int ra = this->find(a);
        int rb = this->find(b);
        if (ra != rb) {
            if (this->heights[ra] < this->heights[rb]) {
                this->parents[ra] = rb;
            } else if (this->heights[ra] > this->heights[rb]) {
                this->parents[rb] = ra;
            } else {
                this->parents[rb] = ra;
                this->heights[ra]++;
            }
            this->parts--;
        }
    }

    int getParts() const {
        return this->parts;
    }

private:
    int find(int node) {
        if (this->parents[node] != node) {
            this->parents[node] = find(this->parents[node]);
        }
        return this->parents[node];
    }
};

class NumberOfConnectedComponentsInAnUndirectedGraph {
public:
    int countComponents1(int n, vector<vector<int> >& edges) {
        // adj mat
        vector<vector<bool> > adj(n, vector<bool>(n, false));
        for (size_t i = 0; i < edges.size(); ++i) {
            adj[edges[i][0]][edges[i][1]] = true;
            adj[edges[i][1]][edges[i][0]] = true;
        }
        // visited
        unordered_set<int> visited;
        int ans = 0;
        for (size_t i = 0; i < (size_t)n; ++i) {
            if (visited.find(i) == visited.end()) {
                // one node that is not connected to any previous component
                ans++;
                // mark all nodes connected to this one visited
                this->dfs(adj, visited, (int)i);
            }
        }
        return ans;
    }

    int countComponents3(int n, vector<vector<int> >& edges) {
        DSU dsu(n);
        for (size_t i = 0; i < edges.size(); ++i) {
            dsu.union_(edges[i][0], edges[i][1]);
        }
        return dsu.getParts();
    }

private:
    void dfs(
        vector<vector<bool> >& adj, unordered_set<int>& visited, int node
    ) {
        visited.insert(node);
        for (size_t i = 0; i < adj.size(); ++i) {
            if (adj[node][i] && visited.find((int)i) == visited.end()) {
                this->dfs(adj, visited, (int)i);
            }
        }
    }
};


int main() {
    NumberOfConnectedComponentsInAnUndirectedGraph test;
    vector<vector<int> > edges1;
    vector<int> e1;
    e1.push_back(0);
    e1.push_back(1);
    vector<int> e2;
    e2.push_back(0);
    e2.push_back(2);
    edges1.push_back(e1);
    edges1.push_back(e2);
    // int result2 = solution.countComponents1(n, edges);
    std::cout << test.countComponents1(3, edges1) << std::endl;
    // std::cout << "Number of connected components (DSU): " << result2 << std::endl;
    return EXIT_SUCCESS;
}