

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class LetterCombPhoneNumJava {
    public static void main(String[] args) {
        System.out.println(LetterCombPhoneNumJava.letterCombinations2("23"));
        System.out.println(LetterCombPhoneNumJava.letterCombinations2(""));
    }

    public static List<String> letterCombinations2(String digits) {
        if ("".equals(digits)){return new ArrayList<String>();}
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<String>();
        ans.add("");
        // take out a digit from input
        // put its corresponding letters into the List separately
        // take out the next digit, append each letter to each String in the List
        // a, b, c => ad, ae, af, bd, be, bf, ... => adg, adh, adi, aeg, aeh, ...
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            char[] chars = mapping[num].toCharArray();
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
}
