# -*- coding: utf-8 -*-

class AddBinary:
    def addBinary(self, a: "str", b: "str") -> "str":
        ans = ''
        i = len(a) - 1
        j = len(b) - 1
        carry = 0
        while i >= 0 or j >= 0:
            num1 = 0 if i < 0 else a[i]
            num2 = 0 if j < 0 else b[j]
            sum_ = int(num1) + int(num2) + carry
            carry = 0
            if sum_ >= 2:
                carry = 1
                sum_ = sum_ % 2
            ans = str(sum_) + ans
            i -= 1
            j -= 1
        if carry: ans = '1' + ans
        return ans

    def addBinary2(self, a: "str", b: "str") -> "str":
        """
        Thought about this, failed in java
        """
        return bin(int(a, 2) + int(b, 2))[2:]


def main():
    test = AddBinary()
    print(test.addBinary2("11", "1"))
    print(test.addBinary2("1010", "1011"))


if __name__ == "__main__":
    main()
