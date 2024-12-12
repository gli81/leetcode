# -*- coding: utf -8-*-

class SimplifyPath:
    def simplifyPath(self, path: "str") -> "str":
        lst1 = path.split('/')
        lst2 = []
        for ele in lst1:
            if ele not in ['.', '']: lst2.append(ele)
        ## deal with ..
        lst1 = []
        for i in range(len(lst2)):
            if lst2[i] == "..":
                if lst1: lst1.pop()
            else:
                lst1.append(lst2[i])
        ans = '/'.join(lst1)
        return '/' + ans


def main():
    test = SimplifyPath()
    print(test.simplifyPath("/home/"))
    print(test.simplifyPath("/../"))
    print(test.simplifyPath("/a/./b/../../c/"))
    print(test.simplifyPath("/a//b////c/d//././/.."))

if __name__ == "__main__":
    main()
