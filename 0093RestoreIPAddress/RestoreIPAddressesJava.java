

import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddressesJava {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        get_ans(s, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    private void get_ans(String s, List<String> ans,
                         StringBuilder cur, int start, int ct) {
        if (s.length() > 12) return;
        if (start == s.length()) {
            if (ct == 4) {
                ans.add(new String(
                    cur.substring(0, cur.length() - 1)
                ));
                return;
            } else {
                // too short
                return;
            }
        }
        if (start < s.length() && ct == 4) return; // too long
        StringBuilder temp = new StringBuilder(cur);
        // add one digit
        cur.append(s.charAt(start) + "" + '.');
        get_ans(s, ans, cur, start + 1, ct + 1);
        if (s.charAt(start) == '0') return;
        // add two digits
        if (start + 2 <= s.length()) {
            cur = new StringBuilder(temp);
            cur.append(s.substring(start, start + 2) + "" + '.');
            get_ans(s, ans, cur, start + 2, ct + 1);
        }
        // add three digits
        if (start + 3 <= s.length()) {
            cur = new StringBuilder(temp);
            int num = Integer.parseInt(s.substring(start, start + 3));
            if (num >= 0 && num <= 255) {
                cur.append(
                    s.substring(start, start + 3) + "" + '.'
                );
                get_ans(s, ans, cur, start + 3, ct + 1);
            }

        }
    }

    
    public static void main(String[] args) {
        RestoreIPAddressesJava test = new RestoreIPAddressesJava();
        System.out.println(
            test.restoreIpAddresses("25525511135")
        );
        System.out.println(
            test.restoreIpAddresses("0000")
        );
        System.out.println(
            test.restoreIpAddresses("101023")
        );
    }
}
