

public class LongestPalindromicSubstringJava {
    public String longestPalindrome4(String s) {
        int len1 = 0, len2 = 0, len = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            len1 = palindromeCenteredAt(s, i, i);
            len2 = palindromeCenteredAt(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindromeCenteredAt(String s, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 2 + 1;
    }


    public static void main(String[] args) {
        String s = "liguangzhenghaoshuaiiauhs";
        LongestPalindromicSubstringJava test =
            new LongestPalindromicSubstringJava();
        System.out.println(test.longestPalindrome4(s));
    }
}
