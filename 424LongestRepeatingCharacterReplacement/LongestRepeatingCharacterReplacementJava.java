public class LongestRepeatingCharacterReplacementJava {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) return len;
        char[] char_arr = s.toCharArray();
        int l, r, ans, max_ct;
        l = r = ans = max_ct = 0;
        int[] freq = new int[26];
        while (r < len) {
            int ind = char_arr[r++] - 'A';
            freq[ind]++;
            max_ct = Math.max(freq[ind], max_ct);
            if (max_ct + k < r - l) {
                freq[char_arr[l++] - 'A']--;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }


    public static void main(String[] args) {
        LongestRepeatingCharacterReplacementJava test = 
            new LongestRepeatingCharacterReplacementJava();
        System.out.println(
            test.characterReplacement("ABAB", 2)
        );
        System.out.println(
            test.characterReplacement("AABABBA", 1)
        );
    }
}