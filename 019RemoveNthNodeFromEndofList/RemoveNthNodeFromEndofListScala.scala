

object RemoveNthNodeFromEndofListScala {

    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        // left right
        var left = head
        var right = head
        // move right
        for (i <- 0 until n) right = right.next
        if (right == null) return head.next
        while (right.next != null) {
            right = right.next
            left = left.next
        }
        // right at the end of the LinkedList, change left.next
        left.next = left.next.next
        head
    }

    def main(args: Array[String]): Unit = {
        println("我是懒子")
    }

    case class ListNode(var x: Int = 0, var next: ListNode = null)
}