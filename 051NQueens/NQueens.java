
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static void main (String[] args) {
        NQueens test = new NQueens();
        // System.out.println(test.solveNQueens(1));
        System.out.println(test.solveNQueens(3));
        System.out.println(test.solveNQueens(9));
        // System.out.println(test.is_valid(Arrays.asList(1, 3, null, null), 2, 0));
    }

    public List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<List<String>>(n);
        backtrack(new ArrayList<Integer>(n), ans, 0, n);
        return ans;
    }

    private void backtrack(List<Integer> pos, List<List<String>> ans, int y, int n) {
        for (int i = 0; i < n; i++) {
            if (is_valid(pos, i, y)) {
                pos.add(i);
                System.out.println(pos);
                if (pos.size() == n) return;
                backtrack(pos, ans, y + 1, n);
            }
        }
        pos.remove(y - 1);
        return;
    }

    private boolean is_valid(List<Integer> pos, int x, int y) {
        // int n = pos.size();
        // row
        for (int i = 0; i < y; i++) if (pos.get(i) == x) return false;
        // diagonal 
        for (int i = 0; i < y; i++) {
            if (pos.get(i) == x + y - i) return false; // need improve, some early cols don't need check
        }
        // reverse diagonal
        for (int i = 0; i < y; i++) {
            if (pos.get(i) == x - y + i) return false; // need improve, some early cols don't need check
        }
        return true;
    }
}