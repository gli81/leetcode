# -*- coding: utf-8 -*-

from typing import List

class FindAllAnagramsinaString:
    def findAnagrams0(self,
                     s: "str",
                     p: "str") -> "List[int]":
        """
        先用p来创建一个dict
        然后从s中框出一个和p等长的部分
        比较是否是anagram
        正确的但超时
        """
        if len(s) < len(p): return []
        p_len = len(p)
        ans = []
        for i in range(0, len(s) - p_len + 1):
            chec = {}
            shime = True
            for letter in p:
                chec[letter] = chec.get(letter, 0) + 1
            for letter in s[i : i + p_len]:
                chec[letter] = chec.get(letter, 0) - 1
            for num in chec.values():
                if num != 0:
                    shime = False
                    break
            if shime: ans.append(i)
        return ans

    def findAnagrams1(self,
                     s: "str",
                     p: "str") -> "List[int]":
        """
        先取s中的前p个
        依次向后移动，从s_lst中去掉第一个字母，加上下一个字母
        """
        s_len, p_len = len(s), len(p)
        if s_len < p_len: return []
        s_lst = [0] * 26
        p_lst = [0] * 26
        a_num = ord('a')
        ans = []
        for i in range(p_len):
            s_lst[ord(s[i]) - a_num] += 1
            p_lst[ord(p[i]) - a_num] += 1
        if s_lst == p_lst: ans.append(0)
        for i in range(s_len - p_len):
            ##最后一个移除的s_len - p_len
            s_lst[ord(s[i]) - a_num] -= 1
            s_lst[ord(s[i + p_len]) - a_num] += 1
            if s_lst == p_lst: ans.append(i + 1)
        return ans


def main():
    test = FindAllAnagramsinaString()
    print(test.findAnagrams1("cbaebabacd", "abc"))
    print(test.findAnagrams1("abab", "ab"))

if __name__ == "__main__":
    main()
