#include <vector>
#include <queue>
using std::vector;
using std::queue;
using std::pair;
using std::make_pair;

class PacificAtlanticWaterFlow {
public:
    vector<vector<int> > pacificAtlantic(vector<vector<int> >& heights) {
        vector<vector<int> > ans;
        size_t m = heights.size();
        if (m == 0) return ans;
        size_t n = heights[0].size();
        if (n == 0) return ans;
        vector<vector<bool> > atl = vector<vector<bool> >(
            m, vector<bool>(n, false)
        );
        vector<vector<bool> > pac = vector<vector<bool> >(
            m, vector<bool>(n, false)
        );
        queue<pair<size_t, size_t> > aq;
        queue<pair<size_t, size_t> > pq;
        for (size_t i = 0; i < m; ++i) {
            aq.push(make_pair(i, n-1));
            pq.push(make_pair(i, 0));
        }
        for (size_t j = 0; j < n; ++j) {
            aq.push(make_pair(m-1, j));
            pq.push(make_pair(0, j));
        }
        // bfs
        vector<pair<int, int> > dirs;
        dirs.push_back(make_pair(0, 1));
        dirs.push_back(make_pair(0, -1));
        dirs.push_back(make_pair(1, 0));
        dirs.push_back(make_pair(-1, 0));
        while (!aq.empty()) {
            pair<size_t, size_t> cur = aq.front(); aq.pop();
            atl[cur.first][cur.second] = true;
            for (size_t i = 0; i < 4; ++i) {
                int new_x = (int)cur.first + dirs[i].first;
                int new_y = (int)cur.second + dirs[i].second;
                if (
                    new_x >= 0 && new_x < m
                    && new_y >= 0 && new_y < n
                    && !atl[new_x][new_y]
                    && heights[cur.first][cur.second] <= heights[new_x][new_y]
                ) {
                    aq.push(make_pair((size_t)new_x, (size_t)new_y));
                }
            }
        }
        while (!pq.empty()) {
            pair<size_t, size_t> cur = pq.front(); pq.pop();
            pac[cur.first][cur.second] = true;
            for (size_t i = 0; i < 4; ++i) {
                int new_x = (int)cur.first + dirs[i].first;
                int new_y = (int)cur.second + dirs[i].second;
                if (
                    new_x >= 0 && new_x < m
                    && new_y >= 0 && new_y < n
                    && !pac[new_x][new_y]
                    && heights[cur.first][cur.second] <= heights[new_x][new_y]
                ) {
                    pq.push(make_pair((size_t)new_x, (size_t)new_y));
                }
            }
        }
        for (size_t i = 0; i < m; ++i) {
            for (size_t j = 0; j < n; ++j) {
                if (atl[i][j] && pac[i][j]) {
                    vector<int> tmp;
                    tmp.push_back(i);
                    tmp.push_back(j);
                    ans.push_back(tmp);
                }
            }
        }
        return ans;
    }
};
