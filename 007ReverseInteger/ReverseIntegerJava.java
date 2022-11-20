

import java.util.Scanner;

public class ReverseIntegerJava {
    public int reverse(int x) {
        // Java % operation will keep the negative sign, Python % will not
        int ans = 0;
        while(x != 0) {
            int diggy = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + diggy;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a num and reverse it");
            System.out.println("enter 6203 to stop the program");
            System.out.print("Please enter the number you want to reverse: ");
            int num = scan.nextInt();
            if (num == 6203) {
                break;
            }
            System.out.println(new ReverseIntegerJava().reverse(num) + "\n");
        }
        // System.out.println(-125 / 10);
        // System.out.println(-125 % 10);
        scan.close();
    }
}
