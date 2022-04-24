

import java.util.Scanner;

public class StringToIntegerJava {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "";
        while (true) {
            System.out.println("Please enter a string to be parsed into an integer");
            System.out.println("Enter \"stop\" to stop the program");
            System.out.print("Enter: ");
            s = scan.nextLine();
            if (s.equals("stop")) {
                break;
            }
            System.out.println(new StringToIntegerJava().myAtoi(s) + "\n");
        }
    }

    public int myAtoi(String s) {
        int ans = 0;
        int signFlag = 1;
        boolean started = false;
        for(int i = 0; i < s.length(); i++) {
            char ltr = s.charAt(i);
            if (ltr == ' ' && !started) {
                continue;
            }
            if (ltr == ' '){
                break;
            }
            if (ltr == '-' && !started) {
                signFlag = -1;
                started = true;
                continue;
            }
            if (ltr == '+' && !started) {
                started = true;
                continue;
            }
            if (ltr >= '0' && ltr <= '9') {
                started = true;
                int diggy = ltr - '0';
                if (ans * signFlag > Integer.MAX_VALUE / 10 || (ans * signFlag == Integer.MAX_VALUE / 10 && diggy > 7)) {
                    return Integer.MAX_VALUE;
                }
                if (ans * signFlag < Integer.MIN_VALUE / 10 || (ans * signFlag == Integer.MIN_VALUE / 10 && diggy > 8)) {
                    return Integer.MIN_VALUE;
                }
                // the real operation of all these shits
                ans = ans * 10 + diggy;
            } else {
                break;
            }
        }
        return ans * signFlag;
    }
}
