

import scala.collection.mutable.ListBuffer

object ZigzagConversion3Scala {
    def convert(s: String, numRows: Int): String = {
        if (numRows == 1) return s
        val list: List[Char] = s.toList
        val cycle = new ListBuffer[Int]()
        for (i <- 0 until s.length) {
            val index : Int = i % (numRows * 2 -2)  //numRows = 4: 0, 1, 2, 3, 4, 5
            val toBeAppend : Int = if (index < numRows) index  else numRows * 2 - 2 - index
            //numRows = 4: 0, 1, 2, 3, 2, 1
            cycle.append(toBeAppend)
        }
        new String(cycle.toList.zip(list).sortBy(_._1).map(_._2).toArray)
    }

    def main(args : Array[String]) : Unit = {
        println(convert("A", 1))
        println(convert("PAYpalisSHIR1NG", 3))
    }
}