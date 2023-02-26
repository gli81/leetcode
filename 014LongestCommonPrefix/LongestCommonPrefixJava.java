

public class LongestCommonPrefixJava {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length == 0 || strs == null) {return "";}
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || 
                    c != strs[j].charAt(i)) {
                    return ans;
                }
            }
            ans = ans + c;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
            new LongestCommonPrefixJava().
                longestCommonPrefix(
                    new String[]{"flower","flow","flight"}
                )
        );
    }
}
