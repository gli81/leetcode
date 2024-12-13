#include <vector>
using std::vector;
#include <queue>
using std::queue;
using std::pair;
using std::make_pair;

class RottingOranges {
public:
    int orangesRotting(vector<vector<int> >& grid) {
        size_t m = grid.size();
        if (m == 0) return 0;
        size_t n = grid[0].size();
        if (n == 0) return 0;
        unsigned fresh = 0;
        queue<size_t> q;
        for (size_t i = 0; i < m; ++i) {
            for (size_t j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.push(i * n + j);
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        if (fresh == 0) return 0;
        unsigned time = 0;
        vector<pair<int, int> > dirs;
        dirs.push_back(make_pair(1, 0));
        dirs.push_back(make_pair(-1, 0));
        dirs.push_back(make_pair(0, 1));
        dirs.push_back(make_pair(0, -1));
        while (!q.empty()) {
            ++time;
            size_t cur_len = q.size();
            for (size_t i = 0; i < cur_len; ++i) {
                size_t cur = q.front(); q.pop();
                for (size_t j = 0; j < 4; ++j) {
                    int new_x = cur / n + dirs[j].first;
                    int new_y = cur % n + dirs[j].second;
                    if (
                        new_x >= 0 && new_x < m
                        && new_y >= 0 && new_y < n
                        && grid[new_x][new_y] == 1
                    ) {
                        grid[new_x][new_y] = 2;
                        q.push(new_x * n + new_y);
                        --fresh;
                    }
                }
            }
        }
        return fresh != 0 ? -1 : time;
    }
};
