

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TrieNode import TrieNode

class DesignAddandSearchWordsDataStructure:
    def __init__(self):
        self.root = TrieNode()
    

    def addWord(self, word: "str") -> "None":
        cur = self.root
        for c in word:
            if not cur.children[ord(c) - ord('a')]:
                cur.children[ord(c) - ord('a')] = TrieNode()
            cur = cur.children[ord(c) - ord('a')]
        cur.end = True
    
    def search(self, word: "str") -> "bool":
        return self.__searchHelper(word, 0, self.root)

    def __searchHelper(self, word: "str", idx: "int", root: "TrieNode") -> "bool":
        cur = root
        for i in range(idx, len(word)):
            if word[i] == '.':
                for child in cur.children:
                    if child and self.__searchHelper(word, i + 1, child):
                        return True
                return False
            else:
                if cur.children[ord(word[i]) - ord('a')]:
                    cur = cur.children[ord(word[i]) - ord('a')]
                else:
                    return False
        return cur.end


def main():
    test = DesignAddandSearchWordsDataStructure()

if __name__ == "__main__":
    main()
