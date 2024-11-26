

#include <vector>
#include <queue>
#include <iostream>
using std::vector;
using std::queue;
using std::pair;
using std::size_t;

class MaxAreaofIsland {
public:
    int maxAreaofIsland(vector<vector<int> > grid) {
        size_t m = grid.size();
        if (m == 0) {
            return 0;
        }
        size_t n = grid[0].size();
        vector<pair<int, int> > dirs;
        dirs.push_back(std::make_pair(1, 0));
        dirs.push_back(std::make_pair(-1, 0));
        dirs.push_back(std::make_pair(0, 1));
        dirs.push_back(std::make_pair(0, -1));
        vector<vector<bool> > visited(m, vector<bool>(n, false));
        // for (size_t i = 0; i < m; ++i) {
        //     for (size_t j = 0; j < n; ++j) {
        //         visited[i].push_back(false);
        //     }
        // }
        int ans = 0;
        for (size_t i = 0; i < m; ++i) {
            for (size_t j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    // found new island
                    queue<pair<size_t, size_t> > q;
                    q.push(std::make_pair(i, j));
                    visited[i][j] = true;
                    size_t area = 1;
                    while (!q.empty()) {
                        pair<size_t, size_t> cur = q.front();
                        q.pop();
                        for (size_t k = 0; k < dirs.size(); ++k) {
                            pair<int, int> d = dirs[k];
                            int nx = cur.first + d.first;
                            int ny = cur.second + d.second;
                            if (
                                nx >= 0 && nx < (int)m &&
                                ny >= 0 && ny < (int)n &&
                                !visited[nx][ny] && grid[nx][ny] == 1
                            ) {
                                area++;
                                visited[nx][ny] = true;
                                q.push(std::make_pair(nx, ny));
                            }
                        }
                    }
                    ans = std::max(ans, (int)area);
                }
            }
        }
        return ans;
    }
};


int main() {
    MaxAreaofIsland test;
    vector<vector<int> > t1;
    t1.push_back(vector<int>());
    t1.push_back(vector<int>());
    t1[0].push_back(1);
    t1[0].push_back(0);
    t1[1].push_back(0);
    t1[1].push_back(0);
    std::cout << test.maxAreaofIsland(t1) << std::endl;
}
