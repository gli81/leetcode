# -*- coding: utf-8 -*-

from typing import List, Tuple

class MaximumProfitinJobScheduling:
    def jobScheduling(
        self,
        startTime: "List[int]",
        endTime: "List[int]",
        profit: "List[int]"
    ) -> "int":
        ## 总之是要先排序的
        ## 为什么是根据endTime排序啊
        ## 确保第i-2个会在第i-1个之前结束
        ## 就只会出现
        """
         ----------
                -----------
        ---------------------------------
        """
        ## 的情况
        ## 不会出现
        """
        --------------------------
           -----------
                ----------------
        """
        ## 的情况
        jobs = sorted(zip(startTime, endTime, profit), key=lambda x:x[1])
        n = len(startTime)
        ## 第0位表示没有任何兼职时的max salary
        dp = [0] * (n + 1)
        # print(dp)
        # for job in jobs: print(job)
        for i in range(1, n + 1):
            ## dp[i - 1]是截止到前一个兼职的max salary
            ## jobs[i - 1]是当前job
            ## dp和jobs的indexing有些偏差😅
            dp[i] = max(
                dp[i - 1],
                dp[self.__binary_search(jobs, jobs[i - 1][0], i - 1)] + jobs[i - 1][2]
            )
        # print(dp)
        return dp[n]
    
    def __binary_search(
        self,
        jobs: "List[Tuple[int, int, int]]",
        target: "int",
        end: "int"
    ) -> "int":
        ## actually find the first that is smaller than target
        l = 0
        r = end
        while l <= r:
            mid = l + (r - l) // 2
            if jobs[mid][1] > target:
                r = mid - 1
            else: l = mid + 1
        return l


def main():
    test = MaximumProfitinJobScheduling()
    print(test.jobScheduling(
        [1, 2, 3, 3],
        [3, 4, 5, 6],
        [50, 10, 40, 70]
    ))

if __name__ == "__main__":
    main()
