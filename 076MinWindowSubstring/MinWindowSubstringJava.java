

public class MinWindowSubstringJava {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int ans_left = 0;
        int ans_right = -1;
        int ans_len = Integer.MAX_VALUE;
        
        return null;
    }
    public static void main(String[] args) {
        MinWindowSubstringJava test = new MinWindowSubstringJava();
        System.out.println(test.minWindow("ADOBECODEBANC",
                                            "ABC"));
        System.out.println(test.minWindow("a", "a"));
        System.out.println(test.minWindow("a", "aa"));
    }    
}
