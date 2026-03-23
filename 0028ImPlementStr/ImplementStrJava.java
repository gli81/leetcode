

public class ImplementStrJava {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int ans = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ImplementStrJava test = new ImplementStrJava();
        System.out.println(test.strStr("hello", "ll"));
        System.out.println(test.strStr("", "a"));
        System.out.println(test.strStr("abc", "c"));
    }
}
