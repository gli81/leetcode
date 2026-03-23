

import java.util.HashMap;

public class InterleavingStringJava {
    /**
     * backtracking with memoization
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        return get_ans(s1, s2, s3, 0, 0, 0,
            new HashMap<String, Boolean>());
    }

    private boolean get_ans(String s1,
                            String s2,
                            String s3,
                            int i,
                            int j,
                            int k,
                            HashMap<String, Boolean> map) {
        // filter out some cases
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        String key = i + "&" + j;
        if (map.containsKey(key)) return map.get(key);
        // return true when i, j, k all at the end
        if (i == s1.length() &&
            j == s2.length() &&
            k == s3.length()) {
                map.put(key, true);
                return true;
            }
        // TODO deal with s1 at end
        if (i == s1.length()) {
            // keep comparing s2 and s3
            while (j < s2.length()) {
                if (s2.charAt(j) != s3.charAt(k)) {
                    map.put(key, false);
                    return false;
                }
                j++;
                k++;
            }
            map.put(key, true);
            return true;
        }
        // TODO similary deal with s2 at end
        if (j == s2.length()) {
            // keep comparing s2 and s3
            while (i < s1.length()) {
                if (s1.charAt(i) != s3.charAt(k)) {
                    map.put(key, false);
                    return false;
                }
                i++;
                k++;
            }
            map.put(key, true);
            return true;
        }
        // next char in s1 equals next char in s3
        // move i, k forward
        if (s1.charAt(i) == s3.charAt(k)) {
            if (get_ans(s1, s2, s3, i + 1, j, k + 1, map)) {
                // put in map
                map.put(key, true);
                return true;
            }
        }
        // next char in s1 doesn't equal next char in s3
        // try next char in s2 with next char in s3
        if (s2.charAt(j) == s3.charAt(k)) {
            if (get_ans(s1, s2, s3, i, j + 1, k + 1, map)) {
                // put in map
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }


    public static void main(String[] args) {
        InterleavingStringJava test = 
            new InterleavingStringJava();
        System.out.println(test.isInterleave("aabcc",
                                             "dbbca",
                                             "aadbbbaccc"));
    }
}