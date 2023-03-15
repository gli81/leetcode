

import java.util.ArrayList;

public class TextJustification {
    public String fullyJustify(String[] words, int maxWidth) {
        return null;
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