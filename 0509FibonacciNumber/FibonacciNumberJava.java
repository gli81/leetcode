
public class FibonacciNumberJava{
    public int fib1(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib2(n - 1) + fib2(n - 2);
    }


    public static void main(String[] args) {
        FibonacciNumberJava test = new FibonacciNumberJava();
        for (int i = 0; i <= 30; i++) {
            System.out.println(test.fib1(i));
        }
    }
}

