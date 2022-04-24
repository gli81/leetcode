


import java.util.Scanner
import scala.util.control.Breaks._

class StringToIntegerScala {
    def myAtoi(s: String): Int = {
        var ans: Int = 0
        var signFlag: Int = 1
        var started: Boolean = false
        try {
            for (i <- s) {
                i match {
                    case digit if digit >= '0' && digit <= '9' => {
                        started = true
                        val diggy: Int = digit - '0'
                        if (ans * signFlag > Integer.MAX_VALUE / 10 || (ans * signFlag == Integer.MAX_VALUE / 10 && diggy > 7)) return Integer.MAX_VALUE
                        if (ans * signFlag < Integer.MIN_VALUE / 10 || (ans * signFlag == Integer.MIN_VALUE / 10 && diggy > 8)) return Integer.MIN_VALUE
                        ans = ans * 10 + diggy
                    }
                    case pos if pos == '+' && !started => started = true
                    case pos if pos == '-' && !started => {
                        started = true
                        signFlag = -1
                    }
                    case space if space == ' ' && !started =>
                    case _ => throw new RuntimeException
                }
            }
        } catch {
            case ex: Exception =>
        }
        ans * signFlag
    }
}

object StringToIntegerScala {
    def main(args: Array[String]): Unit = {
        val scan: Scanner = new Scanner(System.in)
        var s: String = ""
        breakable {
            while (true) {
                println("Please enter a string to be parsed into an integer")
                println("Enter \"stop\" to stop the program")
                print("Enter: ")
                s = scan.nextLine()
                if (s == "stop") break
                println(new StringToIntegerScala().myAtoi(s) + "\n")
            }
        }
    }
}