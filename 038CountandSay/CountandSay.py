# -*- coding: utf-8 -*-

class CountandSay:
    def countAndSay2(self, n: int) -> str:
        ## only 1, return "1"
        ans = "1"

        while n != 1:
            i = 0
            temp = ""
            while i < len(ans):
                rep = self.getRepNum(ans[i:])
                temp = temp + str(rep) + str(ans[i])
                i = i + rep
                # print(i)
            ans = temp
            # print(ans)
            n -= 1
        return ans
    
    '''
    returns the number of same letters at the beginning of the number
    '''
    def getRepNum(self, word: str) -> int:
        ans = 1
        for i in range(1, len(word)):
            if word[i] == word[0]:
                ans += 1
            else:
                break
        return ans

def main():
    test = CountandSay()
    while True:
        # print(test.getRepNum(input("Please enter a number")))
        print(test.countAndSay2(int(input("Please enter a number"))))

if __name__ == "__main__":
    main()