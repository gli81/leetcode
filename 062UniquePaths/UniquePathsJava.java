

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

    private long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        UniquePathsJava test = new UniquePathsJava();
        System.out.println(test.uniquePaths(3, 7));
        System.out.println(test.uniquePaths(3, 2));
        System.out.println(test.uniquePaths(10, 10));
        System.out.println(test.uniquePaths(57, 2));
    }
}