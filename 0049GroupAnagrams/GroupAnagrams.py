# -*- coding: utf-8 -*-

from typing import List

class GroupAnagrams():
    def groupAnagrams0(self, strs: "List[str]") -> "List[List[str]]":
        # ans = []
        words_map = {}
        for word in strs:
            sorted_word = ''.join(sorted(word, key=str.lower))
            if sorted_word not in words_map:
                words_map[sorted_word] = []
            words_map[sorted_word].append(word)
        return list(words_map.values())

    def groupAnagrams1(self, strs: "List[str]") -> "List[List[str]]":
        ans = []
        used = [False * len(strs)]
        for i in range(len(strs)):
            if not used[i]:
                pass
        return None

    def __equals(self, str1: "str", str2: "str") -> "bool":
        pass

def main():
    test = GroupAnagrams()
    print(test.groupAnagrams0(["eat","tea","tan","ate","nat","bat"]))

if __name__ == "__main__":
    main()
