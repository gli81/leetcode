# -*- coding: utf-8 -*-

import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))
from node_structure.ListNode import ListNode
from typing import Optional

class PalindromeLinkedList:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        """
        list
        """
        lst = []
        node = head
        while node is not None:
            lst.append(node.val)
            node = node.next
        l = 0
        r = len(lst) - 1
        while l < r:
            if lst[l] != lst[r]:
                return False
            l += 1
            r -= 1
        return True

def main():
    test = PalindromeLinkedList()

if __name__ == "__main__":
    main()
