

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TextJustification {
    public List<String> fullyJustify(String[] words,
                                        int maxWidth) {
        List<String> ans = new ArrayList<>();
        // current row length
        int curLen = 0;
        List<String> row = new ArrayList<>();
        // cutting the array
        int i = 0;
        while (i < words.length) {
            if (curLen > 0 && 
                    curLen + 1 + words[i].length() <= maxWidth
                || curLen == 0 &&
                    words[i].length() <= maxWidth) {
                row.add(words[i]);
                if (curLen != 0) curLen += 1;
                curLen += words[i].length();
                i++;
            }
            else {
                ans.add(String.join(" ", row));
                row.clear();
                curLen = 0;
            }
        }
        
        ans.add(String.join(" ", row));
        return ans;
    }


    public static void main(String[] args) {
        TextJustification test = new TextJustification();
        System.out.println(test.fullyJustify(
            new String[]{"This", "is", "an",
                            "example", "of", "text",
                            "justification."}, 16
        ));
        System.out.println(test.fullyJustify(
            new String[]{"What", "must", "be",
                            "acknowledgment", "shall",
                            "be"}, 16
        ));
        System.out.println(test.fullyJustify(
            new String[]{"Science", "is", "what", "we",
                            "understand", "well", "enough",
                            "to", "explain", "to", "a",
                            "computer.", "Art", "is",
                            "everything", "else", "we",
                            "do"}, 20
        ));
    }
}