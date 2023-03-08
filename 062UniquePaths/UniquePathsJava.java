

import java.util.HashMap;
import java.util.Map;

public class UniquePathsJava {
    public int uniquePaths(int m, int n) {
        // C( (m + n - 2), (m - 1) )
        // combination
        /*
         * over the size of int type
         */
        // return (int)(factorial(m+n-2) / factorial(m-1) * factorial(n-1));
        int N = n + m - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int)res;
        /*
         * 优化过了，还是溢出 16, 16
         * 
         */
        // int small = Math.min(m, n);
        // int large = Math.max(m, n);
        // long res = 1;
        // for (int i = large; i <= large + small - 2; i++) {
        //     res *= i;
        // }
        // return (int)(res / factorial(small - 1));
    }

    // private long factorial(int n) {
    //     if (n <= 1) return 1;
    //     else return n * factorial(n - 1);
    // }

    // over time limit
    public int uniquePaths2(int m, int n) {
        return get_ans(0, 0, m - 1, n - 1, 0);
    }

    private int get_ans(int x, int y, int m, int n, int num) {
        if (x == m && y == n) return 1;
        int n1, n2;
        n1 = n2 = 0;
        // right
        if (x + 1 <= m) {
            n1 = get_ans(x + 1, y, m, n, num);
        }
        // down
        if (y + 1 <= n) {
            n2 = get_ans(x, y + 1, m, n, num);
        }
        return n1 + n2;
    }

    public int uniquePaths3(int m, int n) {
        Map<String, Integer> visited = new HashMap<>();
        return get_ans(0, 0,
                        m - 1, n - 1, 0, visited);
    }

    private int get_ans(int x, int y, int m, int n, int num,
                        Map<String, Integer> visited) {
        if (x == m && y == n) return 1;
        return 0;
    }

    public static void main(String[] args) {
        UniquePathsJava test = new UniquePathsJava();
        System.out.println(test.uniquePaths2(3, 7));
        System.out.println(test.uniquePaths2(3, 2));
        System.out.println(test.uniquePaths2(10, 10));
        System.out.println(test.uniquePaths2(57, 2));
    }
}