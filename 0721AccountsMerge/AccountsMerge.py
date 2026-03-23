# -*- coding: utf-8 -*-

from typing import List, Dict, Set

class AccountsMerge:
    def accountsMerge(
        self,
        accounts: "List[List[str]]"
    ) -> "List[List[str]]":
        belongs = {}
        ## 用belongs来记录每一个unique的email addr
        ## 都有哪几个list中涉及到
        for i in range(len(accounts)):
            for addr in accounts[i][1:]:
                cur = belongs.get(addr, [])
                cur.append(i)
                belongs[addr] = cur
        email_visited = set()
        id_visited = set()
        ans = []
        for i in range(len(accounts)):
            ## 如果没有check过这条记录
            if i not in id_visited:
                ## 就把这条记录的人名先放进ans里去
                ans.append(accounts[i][:1])
                self.__dfs(
                    i,
                    accounts,
                    id_visited,
                    email_visited,
                    belongs,
                    ans
                )
        for i in range(len(ans)):
            ans[i] = ans[i][:1] + sorted(ans[i][1:])
        return ans

    def __dfs(
        self,
        id: "int",
        accounts: "List[List[str]]",
        id_visited: "Set[int]",
        email_visited: "Set[str]",
        belongs: "Dict[str, List[int]]",
        ans: "List[List[str]]"
    ) -> "None":
        ## 之前check其他record时
        ## 有遇到email能在这条record中也找到
        ## 所以就已经check过这一条了
        if id in id_visited:
            return
        id_visited.add(id)
        ## check传进来的id对应的所有email
        for email in accounts[id][1:]:
            if email in email_visited:
                continue
            email_visited.add(email)
            ##
            ans[-1].append(email)
            ## check每个email的时候
            ## 要去看这个email都在哪几个id中
            ## 被提到了
            ## 如果两条记录都提到了同一个email
            ## 说明这是同一个人
            ## 要放到当前编辑的这个人的list中
            for i in belongs[email]:
                self.__dfs(
                    i, accounts, id_visited,
                    email_visited, belongs, ans
                )


def main():
    test = AccountsMerge()
    print(test.accountsMerge(
        [
            ["Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"],
            ["Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"],
            ["Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"],
            ["Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"],
            ["Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co"]
        ]
    ))
    print(test.accountsMerge(
        [
            ["John", "johnsmith@mail.com", "john00@mail.com"],
            ["John", "johnnybravo@mail.com"],
            ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
            ["Mary", "mary@mail.com"]
        ]
    ))

if __name__ == "__main__":
    main()
