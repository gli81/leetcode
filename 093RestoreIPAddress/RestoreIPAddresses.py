# -*- coding: utf -8-*-

from typing import List

class RestoreIPAddresses:
    def restoreIpAddresses(self, s: "str") -> "List[str]":
        '''
        backtracking
        '''
        ans = []
        self.__get_ans(s, ans, '', 0, 0)
        return ans

    def __get_ans(self, s: "str", ans: "List[str]",
                  cur: "str", start: "int",
                  ct: "int") -> "None":
        ## length > 12 not valid
        if len(s) > 12: return
        if len(s) - start > 3 * (4 - ct): return
        ## get to the end, and have four parts
        if start == len(s):
            if ct == 4:
                ans.append(cur[:-1]) ## ignore the ending dot
                print(cur, end='\t')
                print("yes")
                return
            else:
                print(cur, end='\t')
                print("no")
                return
        ## still number left, already got 4 parts
        if start < len(s) and ct == 4:
            print(cur, end='\t')
            print("no")
            return
        temp = cur
        ## add one digit
        cur += s[start]
        cur += '.'
        self.__get_ans(s, ans, cur, start + 1, ct + 1)
        ## wait for start = start + 1 round
        ## 要开始加多个字符了
        ## 比如要添加一个两位的，如果首位是0，就等到下一轮
        ## 就等到下一轮，按照添加一位的算
        if s[start] == '0': return
        ## add two digits
        if start + 2 <= len(s):
            cur = temp
            cur += s[start : start + 2]
            cur += '.'
            self.__get_ans(s, ans, cur, start + 2, ct + 1)
        ## add three digits
        if start + 3 <= len(s):
            cur = temp
            num = int(s[start : start + 3])
            if num >= 0 and num <= 255:
                cur += s[start : start + 3]
                cur += '.'
                self.__get_ans(s, ans, cur, start + 3, ct + 1)


def main():
    test = RestoreIPAddresses()
    print(test.restoreIpAddresses("25525511135"))
    print(test.restoreIpAddresses("0000"))
    print(test.restoreIpAddresses("101023"))

if __name__ == "__main__":
    main()
