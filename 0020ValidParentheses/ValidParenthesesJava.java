

import java.util.List;
import java.util.ArrayList;

public class ValidParenthesesJava {
    public boolean isValid(String s) {
        List<Character> container = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    container.add(0, c);
                    // System.out.println(container);
                    break;
                case ')':
                    if (!container.isEmpty() && container.get(0) == '(') {
                        container.remove(0);
                        // System.out.println(container);
                    } else {
                        return false;
                    }
                    break;
                    case ']':
                    if (!container.isEmpty() && container.get(0) == '[') {
                        container.remove(0);
                        // System.out.println(container);
                    } else {
                        return false;
                    }
                    break;
                    case '}':
                    if (!container.isEmpty() && container.get(0) == '{') {
                        container.remove(0);
                        // System.out.println(container);
                    } else {
                        return false;
                    }
            }
        }
        return container.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesesJava().isValid("()"));
        System.out.println(new ValidParenthesesJava().isValid("()[]{}"));
        System.out.println(new ValidParenthesesJava().isValid("(]"));
        System.out.println(new ValidParenthesesJava().isValid("([)]"));
        System.out.println(new ValidParenthesesJava().isValid("{[]}"));

    }
}
