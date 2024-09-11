

import java.util.Scanner


object ReverseIntegerScala {
    def reverse(x : Int) : Int = {
        var start = x
        var ans : Int = 0
        while(start != 0) {
            val diggy : Int = start % 10
            start /= 10
            if(ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) return 0
            ans = ans * 10 + diggy
        }
        ans
    }

    
    def main(args : Array[String]) : Unit = {
        val scan : Scanner = new Scanner(System.in)
        try {
            while(true) {
                println("Enter a num and reverse it")
                println("enter 6203 to stop the program")
                print("Please enter the number you want to reverse: ")
                val num : Int = scan.nextInt()
                if (num == 6203) throw new RuntimeException
                println(reverse(num))
            }
        } catch {
            case ex : Exception => 
        }
    }
}