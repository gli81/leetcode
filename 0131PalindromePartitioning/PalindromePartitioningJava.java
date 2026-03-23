

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioningJava {
    public List<List<String>> partition3(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void partitionHelper(
        String s,
        List<List<String>> ans,
        List<String> cur,
        int idx
    ) {
        if (idx >= s.length()) { // all letters checked
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < s.length(); ++i) {
            if (isPalindrome(s.substring(idx, i + 1))) {
                // check starting next letter
                cur.add(s.substring(idx, i + 1));
                partitionHelper(s, ans, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l, r;
        l = 0;
        r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}