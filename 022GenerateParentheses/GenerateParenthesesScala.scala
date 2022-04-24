

object MergeTwoSortedListsScala {
	def main(args: Array[String]): Unit = {
		println("我继续当懒子")
	}

	def mergeTwoLists1(l1: ListNode, l2: ListNode): ListNode = {
		var one = l1
		var two = l2
		var h: ListNode = new ListNode()
		val ans: ListNode = h
		while(one != null && two != null) {
			if (one.x < two.x) {
				h.next = one
				one = one.next
				h = h.next
			} else {
				h.next = two
				two = two.next
				h = h.next
			}
		}
		if (one == null) {
			h.next = two
		}
		if (two == null) {
			h.next = one
		}
		ans.next
	}
	case class ListNode(val x:Int = 0, var next: ListNode = null)
}