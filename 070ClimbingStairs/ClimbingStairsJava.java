

import java.util.HashMap;

public class ClimbingStairsJava {
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        // to reach n, either from n-1 or from n-2
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs2(int n){
        return climbStairsHelper(n, new HashMap<>());
    }

    private int climbStairsHelper(int n,
        HashMap<Integer, Integer> save) {
        // with memoization
        if (n == 1) return 1;
        if (n == 2) return 2;
        int n1, n2;
        if (!save.containsKey(n - 1)) {
            n1 = climbStairsHelper(n - 1, save);
            save.put(n - 1, n1);
        } else {
            n1 = save.get(n - 1);
        }
        if (!save.containsKey(n - 2)) {
            n2 = climbStairsHelper(n - 2, save);
            save.put(n - 2, n2);
        } else {
            n2 = save.get(n - 2);
        }
        // to reach n, either from n-1 or from n-2
        return n1 + n2;
    }

    public static void main(String[] args) {
        ClimbingStairsJava test = new ClimbingStairsJava();
        System.out.println(test.climbStairs2(1));
        System.out.println(test.climbStairs2(2));
        System.out.println(test.climbStairs2(3));
        System.out.println(test.climbStairs2(45));
    }
}