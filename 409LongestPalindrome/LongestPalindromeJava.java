

class LongestPalindromeJava {
    public int longestPalindrome(String s) {
        int[] index = new int[128];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i)]++;
        }
        boolean out = false;
        int ans = 0;
        for (int i = 0; i < 128; i++) {
            if (!out && index[i] % 2 == 1) {
                out = true;
            }
            if (index[i] > 1) {
                ans = ans + index[i] / 2 * 2;
            }
        }
        if (out) ans++;
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindromeJava test =
            new LongestPalindromeJava();
        System.out.println(
            test.longestPalindrome("abccccdd")
        );
    }
}