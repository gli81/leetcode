# -*- coding: utf-8 -*-

from typing import List

class WordLadder:
    def ladderLength(
        self, beginWord: str, endWord: str, wordList: List[str]
    ) -> int:
        if endWord not in wordList or beginWord == endWord:
            return 0
        wordSet = set(wordList)
        q = [beginWord]
        ans = 0
        while len(q) > 0:
            ans += 1
            len_ = len(q)
            for _ in range(len_):
                word = q.pop(0)
                if word == endWord: return ans
                for j in range(len(word)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        if c == word[j]: continue
                        ## generate new word by changing one character
                        newWord = word[:j] + c + word[j+1:]
                        ## if new word in wordList, add to bfs process
                        if newWord in wordSet:
                            q.append(newWord)
                            ## don't come back later
                            wordSet.remove(newWord)
        return 0


def main():
    test = WordLadder()
    print(
        test.ladderLength(
            "hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]
        )
    )

if __name__ == "__main__":
    main()
