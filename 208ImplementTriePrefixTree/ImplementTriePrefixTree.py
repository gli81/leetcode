# -*- coding: utf-8 -*-

class ImplementTriePrefixTree:
    def __init__(self):
        self.next_ = [None] * 26
        self.end = False


    def insert(self, word: "str") -> "None":
        cur = self
        for c in word:
            idx = ord(c) - ord('a')
            if not cur.next_[idx]:
                cur.next_[idx] = ImplementTriePrefixTree()
            # cur.end = False
            cur = cur.next_[idx]
        cur.end = True


    def search(self, word: "str") -> "None":
        cur = self
        for c in word:
            idx = ord(c) - ord('a')
            if not cur.next_[idx]: return False
            cur = cur.next_[idx]
        return cur.end


    def startsWith(self, prefix: "str") -> "bool":
        cur = self
        for c in prefix:
            idx = ord(c) - ord('a')
            if not cur.next_[idx]: return False
            cur = cur.next_[idx]
        return True


def main():
    test = ImplementTriePrefixTree()
    test.insert("apple")
    print(test.search("apple"))
    print(test.search("app"))
    print(test.startsWith("app"))
    test.insert("app")
    print(test.search("app"))

if __name__ == "__main__":
    main()
