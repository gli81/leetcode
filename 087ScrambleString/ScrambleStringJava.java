

public class ScrambleStringJava {
    public boolean isScramble(String s1, String s2) {
        // special cases
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

        return false;
    }
    

    public static void main(String[] args) {
        ScrambleStringJava test = new ScrambleStringJava();
        System.out.println(test.isScramble("great", "rgeat"));
        System.out.println(test.isScramble("abcde", "caebd"));
        System.out.println(test.isScramble("a", "a"));
    }
}
