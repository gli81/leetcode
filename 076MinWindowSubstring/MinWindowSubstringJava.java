

public class MinWindowSubstringJava {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int ans_left = 0;
        int ans_right = -1;
        int ans_len = Integer.MAX_VALUE;
        int[] arr = new int[128];
        // t
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }
        while (right < s.length()) {
            char char_right = s.charAt(right);
            arr[char_right]--;
            if (arr[char_right] >= 0) count--;
            // if current window has all letters in t
            while (count == 0) {
                int temp_len = right - left + 1;
                if (temp_len < ans_len) {
                    ans_left = left;
                    ans_right = right;
                    ans_len = temp_len;
                }
                char key = s.charAt(left);
                /*
                 * arr records what we are looking for
                 * when we remove something from the window
                 * we need to put it back to arr
                 */
                arr[key]++;
                if (arr[key] > 0) count++;
                left++;
            }
            right++;
        }
        return s.substring(ans_left, ans_right + 1);
    }
    public static void main(String[] args) {
        MinWindowSubstringJava test = 
                            new MinWindowSubstringJava();
        System.out.println(test.minWindow("ADOBECODEBANC",
                                            "ABC"));
        System.out.println(test.minWindow("a", "a"));
        System.out.println(test.minWindow("a", "aa"));
    }    
}
