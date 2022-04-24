

object SwapNodesinPairsScala {
    def main(args: Array[String]): Unit = {
        println(swapPairs1(
            new ListNode(1,
            new ListNode(2,
            new ListNode(3,
            new ListNode(4))))
        ))
    }

    def swapPairs1(head: ListNode): ListNode = {
        val dummy: ListNode = new ListNode()
        dummy.next = head
        var point = dummy
        while(point.next != null && point.next.next != null) {
            val tmp1: ListNode = point.next
            val tmp2: ListNode = point.next.next
            // println(head)
            point.next = tmp2
            // println(head)
            tmp1.next = tmp2.next
            // println(head)
            tmp2.next = tmp1
            // println(head)
            point = point.next.next
            // println(head)
        }
        dummy.next
    }
    case class ListNode(val x: Int = 0, var next: ListNode = null) {
        override def toString(): String = {
            var value = s"${this.x}"
            var tmp = this
            while (tmp.next != null) {
                tmp = tmp.next
                value = value + s", ${tmp.x}"
            }
            value
        }
    }
}