

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumberJava {
    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };


    public List<String> letterCombinations1(String digits) {
        if ("".equals(digits)){
            return new ArrayList<String>();
        }
        // String[] mapping = new String[]{
        //     "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        // };
        List<String> ans = new ArrayList<String>();
        ans.add("");
        // take out a digit from input
        // put its corresponding letters into the List separately
        // take out the next digit, append each letter to each String in the List
        // a, b, c => ad, ae, af, bd, be, bf, ... => adg, adh, adi, aeg, aeh, ...
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            char[] chars = KEYS[num].toCharArray();
            while (ans.get(0).length() == i) {
                // after every letter added for first digit (index 0)
                // each element should have 1 letter, after second digit, 2 letters
                String t = ans.remove(0);
                for (char c : chars) {
                    ans.add(t + c);
                }
            }
        }
        return ans;
    }

    public List<String> letterCombinations3(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<String>();
        combHelper(digits, ans, "", 0);
        return ans;
    }

    private void combHelper(
        String digits, List<String> ans, String pre, int len
    ) {
        // if complete
        if (len == digits.length()) {
            ans.add(pre);
            return;
        }
        String letters = KEYS[digits.charAt(len) - '0'];
        for (char c : letters.toCharArray()) {
            combHelper(digits, ans, pre + c, len + 1);
        }
    }


    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumberJava test =
            new LetterCombinationsofaPhoneNumberJava();
        System.out.println(test.letterCombinations3("23"));
        System.out.println(test.letterCombinations3(""));
    }
}
