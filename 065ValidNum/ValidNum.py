# -*- coding: utf-8 -*-

class ValidNum:
    def isNumber(self, s: "str") -> "bool":
        if s in ["inf", "-inf", "+inf", "Infinity", "-Infinity", "+Infinity"]:
            return False
        try:
            float(s)
            return True
        except:
            return False

    def isNumber2(self, s: "str" ) -> "bool":
        s = s.strip()
        number = False
        number_after_e = False
        point = False
        e = False
        for char in range(len(s)):
            if s[char].isdigit():
                number = True
                number_after_e = True
            elif s[char] in ['e', 'E']:
                if not number or e:
                    return False
                e = True
                number_after_e = False
            elif s[char] in ['-', '+']:
                if char != 0 and s[char - 1] != 'e':
                    return False
            elif s[char] == '.':
                if e or point: return False
                point = True
            else: return False
        return number and number_after_e

def main():
    test = ValidNum()
    print(test.isNumber2('0'))
    print(test.isNumber2('e'))
    print(test.isNumber2('-'))
    print(test.isNumber2('inf'))


if __name__ == "__main__":
    main()
