
object AddTwoNum1Scala {
    def addTwoNum(l1 : ListNode, l2 : ListNode) : ListNode = {
        var p : ListNode = l1
        var q : ListNode = l2
        val result = new ListNode()

        var current : ListNode = result
        var up : Int = 0
        var sum : Int = 0
        var cur : Int = 0
        while(p != null || q != null) {
            var x = if (p == null) 0 else p.x
            var y = if (q == null) 0 else q.x
            sum = x + y + up
            up = sum / 10
            cur = sum % 10
            current.next = new ListNode(cur)
            current = current.next
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (up == 1) current.next = new ListNode(1)
        result.next
    }

    def main(args : Array[String]) : Unit = {
        val LN987 = new ListNode(7, new ListNode(8, new ListNode(9, null)))
        println(LN987)
        println(LN987.next)
        println(LN987.next.next)
        val LN355 = new ListNode(5, new ListNode(5, new ListNode(3, null)))

        val ans : ListNode = addTwoNum(LN987, LN355)
        println("")
        println("" + ans)
        println("" + ans + " " + ans.next)
        println("" + ans + " " + ans.next + " " + ans.next.next)
        println("" + ans + " " + ans.next + " " + ans.next.next + " " + ans.next.next.next)
    }
}

class ListNode(var x: Int = 0, var next: ListNode = null) {
    override def toString() : String = x.toString
}