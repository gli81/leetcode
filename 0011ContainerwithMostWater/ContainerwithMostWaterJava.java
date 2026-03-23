

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ContainerwithMostWaterJava {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> li = new ArrayList<>();
        // while true, program goes on
        while(true) {
            li.clear();
            System.out.println("Please enter a list of integers");
            System.out.println("Enter negative number to stop input");
            // System.out.println("Enter negative number again to stop the program");
            int num = 0;
            // while not negative, keep reading
            while (true) {
                System.out.print("Please enter ");
                num = scan.nextInt();
                if (num < 0) break;
                li.add(num);
            }
            Integer[] arr = li.toArray(new Integer[li.size()]);
            int[] intArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                intArr[i] = arr[i];
            }
            System.out.println(new ContainerwithMostWaterJava().maxArea2(intArr));
            System.out.print("Continue? (neg num to stop): ");
            num = scan.nextInt();
            if (num < 0) break;
        }
        scan.close();
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;
        while(l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else r--;
        }
        return ans;
    }
}