# -*- coding: utf -8-*-

class DecodeWays:
    def numDecodings3(self, s: "str") -> "int":
        '''
        dynamic planning solution makes the most sense to me
        '''
        len_ = len(s)
        if len_ == 1: return 0 if s == '0' else 1
        ## reach here, s at least two char
        dp = [0] * len_
        dp[-1] = 0 if s[-1] == '0' else 1
        if s[-2] != '0':
            dp[-2] = dp[-1] + 1 if int(s[-2:]) <= 26 else dp[-1]
        for i in range(len_ - 3, -1, -1):
            if s[i] == '0': continue
            ans2 = dp[i + 2] if int(s[i: i + 2]) <= 26 else 0
            dp[i] = dp[i + 1] + ans2
        return dp[0]


def main():
    test = DecodeWays()
    print(test.numDecodings3("12"))
    print(test.numDecodings3("226"))
    print(test.numDecodings3("06"))

if __name__ == "__main__":
    main()
