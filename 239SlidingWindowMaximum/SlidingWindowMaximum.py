# -*- coding: utf-8 -*-

from typing import List
from collections import deque

class SlidingWindowMaximum:
    def maxSlidingWindow(
        self, nums: "List[int]", k: "int"
    ) -> "List[int]":
        """
        queue
        """
        ## 用一个队列来把k个元素装进去
        ## 每移动一次就把最前面的去掉，把新的加进来
        ans = [0] * (len(nums) - k + 1)
        q = nums[:k]
        ans[0] = maxx = max(q)

        for i in range(k, len(nums)):
            ## 不想用max
            ## 分四种情况
            ## 去掉的是最大值 | 去掉的不是最大值
            ## ============|================
            ##    新加入的  |     新加入的     | 加入的大于
            ##             |                | 最大值
            ## =============================|===========
            ##    重新求    |    原最大值     | 加入的小于
            ##             |                | 最大值
            ## =============================|===========
            q.pop(0)
            q.append(nums[i])
            # print(q)
            if nums[i] > maxx:
                maxx = nums[i]
            else:
                if not q[0] == maxx:
                    maxx = max(q)
            ans[i - k + 1] = maxx
        return ans
    
    def maxSlidingWindow2(
        self, nums: "List[int]", k: "int"
    ) -> "List[int]":
        """
        deque
        """
        n = len(nums)
        ans = [0] * (n - k + 1)
        dq = deque() ## index
        ## deal with first window
        for i in range(k):
            if len(dq) == 0:
                dq.append(i)
            else:
                while len(dq) != 0 \
                and nums[dq[-1]] < nums[i]:
                    dq.pop()
                dq.append(i)
        ans[0] = nums[dq[0]]
        l = 1
        for i in range(k, n):
            while len(dq) != 0 and nums[dq[-1]] < nums[i]:
                dq.pop()
            dq.append(i)
            if l > dq[0]: dq.popleft()
            ans[l] = nums[dq[0]]
            l += 1
        return ans


def main():
    test = SlidingWindowMaximum()
    print(test.maxSlidingWindow2(
            [1, 3, -1, -3, 5, 3, 6, 7], 3
        ))

if __name__ == "__main__":
    main()
