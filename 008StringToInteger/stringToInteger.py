# -*- coding: utf-8 -*-

class StringToInteger:
    def myAtoi(self, s: str) -> int:
        ## max int and min int
        MAX = 2 ** 31 - 1
        MIN = -2 ** 31
        ## flag if started, all spaces trimed
        started = False
        ## answer is 0 now
        ans = 0
        ## signFlag to record pos/neg
        signFlag = 1
        for i in s:
            if i == ' ' and not started:
                continue
            if i == ' ':
                break
            if i == '-' and started == False:
                signFlag = -1
                started = True
                continue
            if i == '+' and started == False:
                signFlag = 1
                started = True
                continue
            if not i.isdigit():
                break
            if i.isdigit():
                if started == False:
                    started = True
                diggy = int(i)
                if ans * signFlag > MAX // 10 or (ans * signFlag == MAX // 10 and diggy > 7):
                    return MAX
                if ans * signFlag < MIN // 10 or (ans * signFlag == MIN // 10 + 1 and diggy > 8):
                    return MIN
                ans = ans * 10 + diggy
        return ans * signFlag

        

def main():
    # while(True):
    #     s = input("Please enter a String to be parsed into a integer\nEnter \"stop\" to stop the program\nEnter: ")
    #     if s == "stop":
    #         break
    #     print(StringToInteger().myAtoi(s))
    print(StringToInteger().myAtoi("-2147483649"))
    # print(2**31 - 1)

if __name__ == '__main__':
    main()