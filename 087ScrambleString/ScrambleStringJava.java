

public class ScrambleStringJava {
    public boolean isScramble(String s1, String s2) {
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
                isScramble(
                    s1.substring(0, i),
                    s2.substring(0, i)
                ) &&
                isScramble(s1.substring(i), s2.substring(i))
            ) return true;
            // cut, switch, next
            if (
                isScramble(s1.substring(0, i),
                           s2.substring(i)) &&
                isScramble(s1.substring(i),
                           s2.substring(0, i))
            ) return true;
        }
        return false;
    }
    

    public static void main(String[] args) {
        ScrambleStringJava test = new ScrambleStringJava();
        System.out.println(
            test.isScramble("great", "rgeat")
        );
        System.out.println(
            test.isScramble("abcde", "caebd")
        );
        System.out.println(test.isScramble("a", "a"));
    }
}
