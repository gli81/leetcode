import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesesJava {
    public List<String> generateParenthesis2 (int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, 0, "", n);
        return ans;
    }

    private void backtrack(
        List<String> ans, int l, int r,
        String cur, int n
    ) {
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }
        if (l < n) backtrack(ans, l + 1, r, cur + "(", n);
        if (r < l) backtrack(ans, l, r + 1, cur + ")", n);
    }

    public static void main(String[] args) {
        GenerateParenthesesJava test =
            new GenerateParenthesesJava();
        System.out.println(test.generateParenthesis2(3));
        System.out.println(test.generateParenthesis2(7));
    }
}