

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class PalindromePairsJava {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        // HashMap
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for (int i = 0; i < words.length; ++i) {
            int len = words[i].length();
            if (len == 0) continue;
            for (int j = 0; j <= len; ++j) {
                if (isPalindrome(words[i], j, len - 1)) {
                    String k = words[i].substring(0, j);
                    if (map.containsKey(k) && i != map.get(k)) {
                        ans.add(
                            Arrays.asList(i, map.get(k))
                            );
                        }
                    }
                    if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    String k = words[i].substring(j);
                    if (map.containsKey(k) && i != map.get(k)) {
                        ans.add(
                            Arrays.asList(map.get(k), i)
                        );
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String w, int l, int r) {
        while (l < r) {
            if (w.charAt(l++) != w.charAt(r--)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // String a = "abcd";
        // System.out.println(a.substring(4));
        PalindromePairsJava test = new PalindromePairsJava();
        System.out.println(test.palindromePairs(
            new String[]{"abcd", "dcba", "lls", "s", "sssll", ""}
        ));
    }
}