

#include "TrieNode.hpp"
#include <vector>
#include <string>
#include <cstdlib>
using std::vector;
using std::string;

class WordSearchII {
private:
    TrieNode* root;



public:
    vector<string> findWords2(
        vector<vector<char> >& board,
        vector<string>& words
    ) {
        TrieNode tmp;
        this->root = &tmp;
        // put every word into trie
        for (size_t i = 0; i < words.size(); ++i) {
            addWord(words[i]);
        }
        // check boundary
        size_t r = board.size();
        if (r == 0) {
            return vector<string>();
        }
        size_t c = board[0].size();
        vector<string> ans;
        for (size_t i = 0; i < r; ++i) {
            for (size_t j = 0; j < c; ++j) {
                string cur;
                find2Helper(board, ans, cur, this->root, i, j);
            }
        }
        return ans;
    }

private:
    void addWord(const string& word) {
        TrieNode* cur = this->root;
        for (size_t i = 0; i < word.size(); ++i) {
            char c = word[i];
            if (NULL == cur->children[c - 'a']) {
                cur->children[c - 'a'] = new TrieNode();
            }
            cur = cur->children[c - 'a'];
        }
        cur->end = true;
    }

    void find2Helper(
        vector<vector<char> >& board,
        vector<string>& ans,
        string& cur,
        TrieNode* node,
        size_t r,
        size_t c
    ) {
        // check boundary
        if (r < 0 || r >= board.size() || c < 0 || c >= board[0].size()) {
            return;
        }
        // if repeat grid, or prefix doesn't exist
        char letter = board[r][c];
        if (letter == '#' || NULL == node->children[letter - 'a']) {
            return;
        }
        node = node->children[letter - 'a'];
        cur += letter;
        if (node->end) {
            ans.push_back(cur);
            node->end = false;
        }
        board[r][c] = '#';
        find2Helper(board, ans, cur, node, r + 1, c);
        find2Helper(board, ans, cur, node, r - 1, c);
        find2Helper(board, ans, cur, node, r, c + 1);
        find2Helper(board, ans, cur, node, r, c - 1);
        // backtrack
        cur.pop_back();
        board[r][c] = letter;
    }
};
