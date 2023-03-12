# -*- coding: utf-8 -*-

class ValidNum:
    def isNumber(self, s: "str") -> "bool":
        if s in ["inf", "-inf", "+inf", "Infinity", "-Infinity", "+Infinity"]: return False
        try:
            float(s)
            return True
        except:
            return False

    def isNumber2(self, s: "str" ) -> "bool":
        pass

def main():
    test = ValidNum()
    print(test.isNumber('0'))
    print(test.isNumber('e'))
    print(test.isNumber('-'))


if __name__ == "__main__":
    main()
