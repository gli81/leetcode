#include <vector>
#include <queue>
#include <iostream>
using std::vector;
using std::queue;
using std::pair;
using std::make_pair;
using std::cout;
using std::endl;

class WallsandGates {
public:
    void wallsandGates(vector<vector<int> >& grid) {
        size_t m = grid.size();
        if (m == 0) return;
        size_t n = grid[0].size();
        if (n == 0) return;
        vector<vector<bool> > visited(m, vector<bool>(n, false));
        queue<pair<size_t, size_t> > q;
        for (size_t i = 0; i < m; ++i) {
            for (size_t j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    q.push(make_pair(i, j));
                    visited[i][j] = true;
                }
                if (grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        vector<pair<int, int> > dirs;
        dirs.push_back(make_pair(1, 0));
        dirs.push_back(make_pair(-1, 0));
        dirs.push_back(make_pair(0, 1));
        dirs.push_back(make_pair(0, -1));
        while (!q.empty()) {
            size_t cur_len = q.size();
            ++level;
            for (size_t i = 0; i < cur_len; ++i) {
                pair<size_t, size_t> cur = q.front(); q.pop();
                cout << q.size() << endl;
                for (size_t j = 0; j < 4; ++j) {
                    int newx = cur.first + dirs[j].first;
                    int newy = cur.second + dirs[j].second;
                    if (
                        0 <= newx && newx < (int)m
                        && 0 <= newy && newy < (int)n
                        && !visited[newx][newy]
                    ) {
                        grid[newx][newy] = level;
                        visited[newx][newy] = true;
                        q.push(make_pair((size_t)newx, (size_t)newy));
                    }
                }
            }
        }
    }
};


int main(void) {
    WallsandGates test;
    cout << "hellllo" << endl;
    vector<vector<int> > test1(4, vector<int>(4, 10));
    test1[0][1] = -1;
    test1[0][2] = 0;
    test1[1][3] = -1;
    test1[2][1] = -1;
    test1[2][3] = -1;
    test1[3][0] = 0;
    test1[3][1] = -1;
    test.wallsandGates(test1);
    for (size_t i = 0; i < test1.size(); ++i) {
        for (size_t j = 0; j < test1[0].size(); ++j) {
            cout << test1[i][j];
            if (j != test1[0].size()) {
                cout << ", ";
            }
        }
        cout << endl;
    }
}
