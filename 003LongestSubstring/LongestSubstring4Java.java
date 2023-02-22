
public class LongestSubstring4Java {
    public int longestSubstring(String s) {
        int[] index = new int[128];
        int ans = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcdcca";
        System.out.println(
            new LongestSubstring4Java().longestSubstring(s)
        );
    }
}