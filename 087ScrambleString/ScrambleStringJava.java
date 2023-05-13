import java.util.HashMap;

public class ScrambleStringJava {
    public boolean isScramble1(String s1, String s2) {
        /*
         * exceeds time limit
         */
        // special cases; exiting conditions
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int [] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) return false;
        }

        // real stuff, smaller problem
        for (int i = 1; i < s1.length(); i++) {
            // cut, next
            if (
                isScramble1(
                    s1.substring(0, i),
                    s2.substring(0, i)
                ) &&
                isScramble1(s1.substring(i), s2.substring(i))
            ) return true;
            // cut, switch, next
            if (
                isScramble1(s1.substring(0, i),
                           s2.substring(s2.length() - i)) &&
                isScramble1(s1.substring(i),
                           s2.substring(0, s2.length() - i))
            ) return true;
        }
        return false;
    }
    
    public boolean isScramble2(String s1, String s2) {
        /*
         * with memoization
         */
        return scramble_helper(s1, s2,
                            new HashMap<String, Integer>());
    }

    private boolean scramble_helper(String s1, String s2,
                            HashMap<String, Integer> map) {
        // special cases; exiting conditions
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int [] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) return false;
        }

        // real stuff, smaller problem
        for (int i = 1; i < s1.length(); i++) {
            // cut, next
            if (
                isScramble1(
                    s1.substring(0, i),
                    s2.substring(0, i)
                ) &&
                isScramble1(s1.substring(i), s2.substring(i))
            ) return true;
            // cut, switch, next
            if (
                isScramble1(s1.substring(0, i),
                           s2.substring(s2.length() - i)) &&
                isScramble1(s1.substring(i),
                           s2.substring(0, s2.length() - i))
            ) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        ScrambleStringJava test = new ScrambleStringJava();
        System.out.println(
            test.isScramble2("great", "rgeat")
        );
        System.out.println(
            test.isScramble2("abcde", "caebd")
        );
        System.out.println(test.isScramble2("a", "a"));
        System.out.println(
            test.isScramble2("abb", "bba")
        );
    }
}
