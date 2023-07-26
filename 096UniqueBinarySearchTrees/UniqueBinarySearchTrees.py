# -*- coding:utf-8 -*-

class UniqueBinarySearchTrees:
    def numTrees_my_own(self, n: "int") -> "int":
        '''
        dynamic planning solution
        over time limit at n = 19
        and poor RAM :-)
        should be correct solution, just too complex
        '''
        dp = [0] * (n + 1)
        ## 1 to n ❌, 0 to n
        dp[0] = 1
        dp[1] = 1
        pre = [0]
        ## num of each trees number of right layers
        cur = []
        if not n: return 0
        for num in range(2, n + 1):
            # dp[num] = dp[num - 1]
            # ## insert at root for each tree
            for tree in pre:
                cur.append(0)
                ## insert at root
                for i in range(tree + 1):
                    cur.append(i + 1)
            dp[num] = len(cur)
            # print(f"num: {num}, cur: {cur}")
            # print(dp)
            pre = cur[:]
            cur = []
        return dp[-1]

    def numTrees2(n: "int") -> "int":
        '''
        from leetcode.wang
        doesn't understand the multiply part
        something to do with BST unclear TnT
        '''
        dp = [0] * (n + 1)
        dp[0] = 1
        if not n: return 0
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                left = j - 1
                right = i - j
                dp[i] += dp[left] * dp[right]
        return dp[n]


def main():
    test = UniqueBinarySearchTrees()
    print(test.numTrees2(3))
    print(test.numTrees2(20))
    print(test.numTrees2(5))

if __name__ == "__main__":
    main()