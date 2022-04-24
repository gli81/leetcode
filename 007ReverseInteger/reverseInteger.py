# -*- coding: utf-8 -*-

import sys

class ReverseInteger():
    def reverseInteger(self, x : int) -> int:
        start = x
        neg = False
        if x < 0:
            start = -start
            neg = True
        ans = 0
        while start != 0:
            diggy = start % 10
            start //= 10
            ans = ans * 10 + diggy
        if neg:
            ans = -ans
        if ans > 2**31 - 1 or ans < -2**31: return 0 
        return ans


def main():
    while(True):
            print("Enter a num and reverse it")
            print("enter 6203 to stop the program")
            num = int(input("Please enter the number you want to reverse: "))
            if num == 6203: break
            else:
                print(ReverseInteger().reverseInteger(num))
                print()
    # print(ReverseInteger().reverseInteger(-125))
    # print(-125 % 10)
    

if __name__ == "__main__":
    main()