# -*- coding: utf-8 -*-

class PalindromeNumber:
    def isPalindrome(self, x : int) -> bool:
        def reverse(x : int) -> int:
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
        return (x >= 0 and x == reverse(x))

def main():
    while(True):
        num = int(input("Please enter an integer\nEnter -1 to stop\nEnter: "))
        if num == -1:
            break
        print(PalindromeNumber().isPalindrome(num))

if __name__ == '__main__':
    main()