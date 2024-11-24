

#include <cstdlib>

class TrieNode {
public:
    TrieNode** children;
    bool end;


    TrieNode(): children(new TrieNode*[26]), end(false) {
        for (size_t i = 0; i < 26; ++i) {
            this->children[i] = NULL;
        }
    }

    ~TrieNode() {
        // for (size_t i = 0; i < 26; ++i) {
        //     // recursively delete
        //     delete this->children[i];
        // }
        delete[] this->children;
    }
};
