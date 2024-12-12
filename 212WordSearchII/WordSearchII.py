

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.TrieNode import TrieNode
from typing import List

class WordSearchII:
    root: "TrieNode"

    def findWords1(
        self, board: "List[List[str]]", words: "List[str]"
    ) -> "List[str]":
        pass

    def findWords2(
        self, board: "List[List[str]]", words: "List[str]"
    ) -> "List[str]":
        self.root = TrieNode()
        for s in words:
            self.__addWord(s)
        r = len(words)
        if not r: return []
        c = len(words[0])
        ans = []
        for i in range(r):
            for j in range(c):
                self.__find2Helper(board, ans, '', self.root, i, j)
        return ans

    def __addWord(self, word: "str") -> "None":
        cur = self.root
        for c in word:
            if not cur.children[ord(c) - ord('a')]:
                cur.children[ord(c) - ord('a')] = TrieNode()
            cur = cur.children[ord(c) - ord('a')]
        cur.end = True

    def __find2Helper(
        self,
        board: "List[List[str]]",
        ans: "List[str]",
        cur: "str",
        node: "TrieNode",
        r: "int",
        c: "int"
    ) -> "None":
        ## out of bound
        if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]):
            return
        letter = board[r][c]
        if letter == '#' or node.children[ord(letter) - ord('a')]:
            return ## repeat grid or no such prefix
        cur += letter
        node = node.children[ord(letter) - ord('a')]
        if node.end:
            ## a word found
            ans.append(cur)
            # ans.append(cur[:]) ## similar memory performance
            node.end = False
        board[r][c] = '#'
        self.__find2Helper(board, ans, cur, node, r + 1, c)
        self.__find2Helper(board, ans, cur, node, r - 1, c)
        self.__find2Helper(board, ans, cur, node, r, c + 1)
        self.__find2Helper(board, ans, cur, node, r, c - 1)
        board[r][c] = letter
        cur = cur[:-1]


def main():
    test = WordSearchII()

if __name__ == "__main__":
    main()
