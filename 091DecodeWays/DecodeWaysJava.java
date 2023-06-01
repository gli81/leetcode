

import java.util.HashMap;

public class DecodeWaysJava {
    public int numDecodings1(String s) {
        /*
         * over time limit :)
         */
        return get_ans(s, 0);
    }

    private int get_ans(String s, int start) {
        // when checking the last digit
        // its ans1 would equal to
        // get_ans(s, s.length() - 1 + 1)
        // it will get here
        // for a single digit number, should get a 1
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        // 01 02 03 04 05 06 07 08 09 not valid
        int ans1 = get_ans(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            // if int(s[start: start + 2]) < 26
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = get_ans(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

    public int numDecodings2(String s) {
        /*
         * recursion
         * ac
         */
        return get_ans2(s, 0,
                        new HashMap<Integer, Integer>());
    }

    private int get_ans2(String s, int start,
                         HashMap<Integer, Integer> map) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        int m = map.getOrDefault(start, -1);
        if (m != -1) return m;
        int ans1 = get_ans2(s, start + 1, map);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = get_ans2(s, start + 2, map);
            }
        }
        map.put(start, ans1 + ans2);
        return ans1 + ans2;
    }

    public int numDecodings3(String s) {
        /*
         * dynamic planning
         * more intuitive for me
         * takes less time too
         */
        int len = s.length();
        if (len == 1) return s.charAt(0) == '0' ? 0 : 1;
        // access here, s.length() at least 2 (non empty string)
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') dp[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) ans2 = dp[i + 2];
            dp[i] = dp[i + 1] + ans2;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        DecodeWaysJava test = new DecodeWaysJava();
        System.out.println(test.numDecodings3("12"));
        System.out.println(test.numDecodings3("226"));
        System.out.println(test.numDecodings3("06"));
        System.out.println(test.numDecodings3("30"));
    }
}