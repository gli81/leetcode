

#include <TrieNode.hpp>
#include <string>
#include <cstdlib>

class DesignAddandSearchWordsDataStructure {
private:
    TrieNode* root;


public:
    DesignAddandSearchWordsDataStructure(): root(new TrieNode()) {}

    ~DesignAddandSearchWordsDataStructure() {
        delete this->root; // hate rule of three :D
    }

    DesignAddandSearchWordsDataStructure(
        const DesignAddandSearchWordsDataStructure& rhs
    ) {
        // level order traversal?
    }


    void addWord(std::string word) {
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

    bool search(std::string word) {
        return searchHelper(word, 0, this->root);
    }
    
private:
    bool searchHelper(std::string& word, size_t idx, TrieNode* root) {
        TrieNode* cur = root;
        for (size_t i = idx; i < word.size(); ++i) {
            char c = word[i];
            if (c == '.') {
                for (size_t j = 0; j < 26; ++j) {
                    if (
                        NULL != cur->children[j] &&
                        searchHelper(word, i + 1, cur->children[j])
                    ) {
                        return true;
                    }
                }
                return false;
            } else {
                // actual word
                if (NULL == cur->children[c - 'a']) {
                    return false;
                } else {
                    cur = cur->children[c - 'a'];
                }
            }
        }
        return cur->end;
    }

    DesignAddandSearchWordsDataStructure& operator=(
        DesignAddandSearchWordsDataStructure& rhs
    ) {
        // eee
    }
};
