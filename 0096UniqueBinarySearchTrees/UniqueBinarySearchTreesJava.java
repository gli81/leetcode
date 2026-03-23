
public class UniqueBinarySearchTreesJava {
    public int numTrees_my_own(int n) {
        return 0;
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n == 0) return 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                int left = j - 1;
                int right = i - j;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        UniqueBinarySearchTreesJava test = 
            new UniqueBinarySearchTreesJava();
        System.out.println(test.numTrees2(18));
    }
}