

#include <vector>
#include <string>
#include <iostream>

class WordSearch {
public:
    bool exist(std::vector<std::vector<char> >& board, std::string word) {
        // visited
        // rows of visited
        // std::vector<bool> row;
        size_t m = board.size();
        if (m == 0) return false;
        // for (size_t i = 0; i < board[0].size(); ++i) {
        //     row.push_back(false);
        // }
        size_t n = board[0].size();
        std::vector<std::vector<bool> > visited(m, std::vector<bool>(n, false));
        // for (size_t i = 0; i < m; ++i) {
        //     visited.push_back(row);
        // }
        // visited[0][0] = true;
        for (size_t i = 0; i < m; ++i) {
            for (size_t j = 0; j < n; ++j) {
                // std::cout << visited[i][j];
                // if (j != board[0].size() - 1) {
                //     std::cout << ", ";
                // }
                if (exist_(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
            // std::cout << std::endl;
        }
        return false;
    }

private:
    bool exist_(
        std::vector<std::vector<char> >& board,
        std::string& word,
        std::vector<std::vector<bool> >& visited,
        size_t idx,
        size_t r,
        size_t c
    ) {
        // out of bound
        // if ((r >= board.size() || r < 0) && (c >= board[0].size() || c < 0)) {
        if (r >= board.size() || r < 0 || c >= board[0].size() || c < 0) {
            return false;
        }
        // visited or wrong char
        if (visited[r][c] || board[r][c] != word.at(idx)) {
            return false;
        }
        // got all letters
        if (idx == word.size() - 1) return true;
        // check four directions
        std::pair<int, int> dirs[4] = {
            std::pair<int, int>(1, 0),
            std::pair<int, int>(-1, 0),
            std::pair<int, int>(0, 1),
            std::pair<int, int>(0, -1),
        };
        visited[r][c] = true;
        for (size_t i = 0; i < 4; ++i) {
            if (
                exist_(
                    board,
                    word,
                    visited,
                    idx + 1,
                    r + dirs[i].first,
                    c + dirs[i].second
                )
            ) {
                return true;
            }
        }
        // nothing from any of the four dirs
        visited[r][c] = false;
        return false;
    }
};


int main(void) {
    WordSearch test;
    std::vector<std::vector<char> > test1(3, std::vector<char>(5, 'a'));
    std::cout << test.exist(test1, "abcde") << std::endl;
}
