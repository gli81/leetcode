

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TextJustificationJava {
    public List<String> fullyJustify(String[] words,
                                        int maxWidth) {
        List<String> ans = new ArrayList<>();
        // current row length
        int cur_len = 0;
        List<String> row = new ArrayList<>();
        // cutting the array
        int i = 0;
        while (i < words.length) {
            if (
                cur_len > 0 && 
                cur_len + 1 + words[i].length() <= maxWidth
            ) {
                row.add(" " + words[i]);
                cur_len += 1; // the space
                cur_len += words[i].length();
                i++;
            } else if (
                cur_len == 0 &&
                words[i].length() <= maxWidth
            ) {
                row.add(words[i]);
                cur_len += words[i].length();
                i++;
            } else {
                int need_space = maxWidth - cur_len;
                row = insert_space(row, need_space, false);
                ans.add(String.join("", row));
                row.clear();
                cur_len = 0;
            }
        }
        // add everything left to the ans list
        int need_space = maxWidth - cur_len;
        row = insert_space(row, need_space, true);
        ans.add(String.join("", row));
        return ans;
    }

    private List<String> insert_space(List<String> original,
                                        int n, boolean last) {
        if (last) {
            for (int i = 0; i < n; i++) {
                original.set(original.size() - 1,
                    original.get(original.size() - 1)+ " ");
            }
            return original;
        } else {
            // deal with only one word situation first
            // or indefinite while loop
            if (original.size() == 1) {
                for (int i = 0; i < n; i++) {
                    original.set(0,
                    original.get(0) + " ");
                }
                return original;
            }
            // n = n + original.size() - 1;
            while (n > 0) {
                for (int i = 0; i < original.size() - 1; i++) {
                    original.set(i, original.get(i) + " ");
                    n--;
                    if (n == 0) break;
                }
            }
            // System.out.println(original);
            return original;
        }
    }

    public static void main(String[] args) {
        TextJustificationJava test = 
            new TextJustificationJava();
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