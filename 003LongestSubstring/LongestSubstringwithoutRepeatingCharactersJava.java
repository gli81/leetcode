
public class LongestSubstringwithoutRepeatingCharactersJava
{
    public int lengthOfLongestSubstring4(String s) {
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
        LongestSubstringwithoutRepeatingCharactersJava test = 
            new LongestSubstringwithoutRepeatingCharactersJava();
        System.out.println(
            test.lengthOfLongestSubstring4("abcdcca")
        );
    }
}