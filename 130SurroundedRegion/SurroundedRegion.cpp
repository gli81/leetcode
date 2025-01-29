

#include <vector>
using std::vector;
using std::pair;
using std::make_pair;
using std::size_t;
#include <iostream>

class DSU {
private:
    vector<size_t> parent;
    vector<size_t> size;


public:
    DSU(
        size_t n
    ): parent(vector<size_t>(n)), size(vector<size_t>(n, 0)) {
        for (size_t i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }


    size_t findParent(size_t node) {
        if (parent[node] != node) {
            // has some other parent
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    bool connected(size_t u, size_t v) {
        return findParent(u) == findParent(v);
    }

    bool union_(size_t u, size_t v) {
        size_t pu = findParent(u); size_t pv = findParent(v);
        if (pu == pv) return false;
        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        return true;
    }
};


class SurroundedRegion {
public:
    void solve2(vector<vector<char> >& board) {
        size_t r = board.size();
        if (r == 0) return;
        size_t c = board[0].size();
        for (size_t i = 0; i < r; ++i) {
            if (board[i][0] == 'O') {
                dfs(board, (int)i, 0, r, c);
            }
            if (board[i][c - 1] == 'O') {
                dfs(board, (int)i, (int)(c - 1), r, c);
            }
        }
        for (size_t j = 0; j < c; ++j) {
            if (board[0][j] == 'O') {
                dfs(board, 0, (int)j, r, c);
            }
            if (board[r - 1][j] == 'O') {
                dfs(board, (int)(r - 1), (int)j, r, c);
            }
        }
        // O -> X, T -> O
        for (size_t i = 0; i < r; ++i) {
            for (size_t j = 0; j < c; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    void solve3(vector<vector<char> >& board) {
        size_t r = board.size();
        if (r == 0) return;
        size_t c = board[0].size();
        DSU dsu(r * c + 1);
        vector<pair<int, int> > dirs;
        dirs.push_back(make_pair(-1, 0));
        dirs.push_back(make_pair(1, 0));
        dirs.push_back(make_pair(0, -1));
        dirs.push_back(make_pair(0, 1));
        for (size_t i = 0; i < r; ++i) {
            for (size_t j = 0; j < c; ++j) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    dsu.union_(r * c, i * c + j);
                } else {
                    for (size_t di = 0; di < 4; ++di) {
                        int new_r = i + dirs[di].first; // i must > 0 here
                        int new_c = j + dirs[di].second;
                        if (board[new_r][new_c] == 'O') {
                            dsu.union_(i * c + j, new_r * c + new_c);
                        }
                    }
                }
            }
        }
        for (size_t i = 0; i < r; ++i) {
            for (size_t j = 0; j < c; ++j) {
                if (!dsu.connected(r * c, i * c + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

private:
    void dfs(
        vector<vector<char> >& board, int i, int j, size_t r, size_t c
    ) {
        // compare unsigned to signed, convert both to unsigned
        // make sure i and j is positive
        // so the conversion doesn't change value
        if (
            i < 0 || j < 0 || (size_t)i >= r || (size_t)j >= c 
            || board[i][j] != 'O'
        ) {
            return;
        }
        board[i][j] = 'T';
        dfs(board, i + 1, j, r, c);
        dfs(board, i - 1, j, r, c);
        dfs(board, i, j + 1, r, c);
        dfs(board, i, j - 1, r, c);
    }
};


int main() {
    std::cout << "Compile successfully" << std::endl;
}