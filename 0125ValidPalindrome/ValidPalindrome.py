# -*- coding: utf-8 -*-

class ValidPalindrome:
    def isPalindrome(self, s: "str") -> "bool":
        ## 处理s移除空格标点，全部转换为小写
        st = ''
        for letter in s:
            if letter.isalnum():
                st += letter
        st = st.lower()
        ## 头尾指针
        l = 0
        r = len(st) - 1
        while l <= r:
            if st[l] != st[r]:
                return False
            l += 1
            r -= 1
        return True


def main():
    test = ValidPalindrome()
    print(test.isPalindrome())

if __name__ == "__main__":
    main()
