

public class ScrambleStringJava {
    public boolean isScramble(String s1, String s2) {
        return false;
    }
    

    public static void main(String[] args) {
        ScrambleStringJava test = new ScrambleStringJava();
        System.out.println(test.isScramble("great", "rgeat"));
        System.out.println(test.isScramble("abcde", "caebd"));
        System.out.println(test.isScramble("a", "a"));
    }
}
