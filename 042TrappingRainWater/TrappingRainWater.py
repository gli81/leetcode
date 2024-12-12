# -*- coding: utf-8 -*-

class TrappingRainWater():
    def trap1(self, height: "list[int]") -> "int":
        '''
        row
        overtime
        '''
        rslt = 0
        max_height = max(height)
        for i in range(max_height):
            started = False
            this_sum = 0
            for j in range(len(height)):
                if started and height[j] - 1 < i:
                    this_sum += 1
                if height[j] - 1 >= i:
                    rslt += this_sum
                    '''
                    TODO comments about gaps after the last higher column
                    '''
                    this_sum = 0
                    started = True
        return rslt

    def trap2(self, height: "list[int]") -> "int":
        '''
        column
        overtime
        '''
        rslt = 0
        for i in range(1, len(height) - 1):
            left_highest = height[0]
            ## left highest
            for j in range(1, i):
                if height[j] > left_highest: left_highest = height[j]
            right_highest = height[len(height) - 1]
            ## right highest
            for j in range(len(height) - 2, i, -1):
                if height[j] > right_highest: right_highest = height[j]
            limit = min(left_highest, right_highest)
            if height[i] < limit: rslt =  rslt + limit - height[i]
        return rslt

    def trap3(self, height: "list[int]") -> "int":
        '''
        dynamic planning in finding left high & right high
        '''
        rslt = 0
        arr_len = len(height)
        left_highest = [0] * arr_len
        right_highest = [0] * arr_len
        for i in range(1, arr_len):
            left_highest[i] = max(left_highest[i - 1], height[i - 1])
            right_highest[arr_len - i - 1] = max(
                right_highest[arr_len - i], height[arr_len - i]
            )
        for i in range(arr_len):
            limit = min(left_highest[i], right_highest[i])
            if height[i] < limit: rslt =  rslt + limit - height[i]
        return rslt

    def trap4(self, height: "list[int]") -> "int":
        pass

    def trap5(self, height: "list[int]") -> "int":
        '''
        stk
        '''
        rslt = 0
        current = 0
        stk = []
        while current < len(height):
            while len(stk) != 0 and height[current] > height[stk[-1]]:
                out = stk.pop()
                h = height[out]
                if len(stk) == 0: break
                dist = current - stk[-1] - 1
                limit = min(height[current], height[stk[-1]])
                rslt = rslt + dist * (limit - h)
            stk.append(current)
            current += 1
        return rslt

def main():
    test = TrappingRainWater()
    print(test.trap5([0,1,0,2,1,0,1,3,2,1,2,1]))
    print(test.trap5([4,2,0,3,2,5]))

if __name__ == "__main__":
    main()

'''
class Solution:
    def trap(self, height: List[int]) -> int:
        ans = 0
        h1 = 0
        h2 = 0
        for i in range(len(height)):
            h1 = max(h1,height[i])
            h2 = max(h2,height[-i-1])
            ans = ans + h1 + h2 -height[i]
        return  ans - len(height)*h1
'''
