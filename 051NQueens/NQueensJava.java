

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueensJava {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>(n);
        nQueensHelper(n, ans, new ArrayList<Integer>(n));
        return ans;
    }

    private void backtrack_(
        List<Integer> pos, List<List<String>> ans, int y, int n
    ) {
        for (int i = 0; i < n; i++) {
            if (is_valid(pos, i, y)) {
                pos.add(i);
                // System.out.println(pos);
                if (pos.size() == n) {
                    List<String> tmp_list = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        char[] tmp = new char[n];
                        Arrays.fill(tmp, '.');
                        tmp[pos.get(j)] = 'Q';
                        tmp_list.add(new String(tmp));
                    }
                    ans.add(tmp_list);
                    pos.remove(n - 1);
                    if (n > 1) pos.remove(n - 2);
                    return;
                }
                backtrack_(pos, ans, y + 1, n);
            }
        }
        if (y != 0) pos.remove(y - 1);
        return;
    }

    private boolean is_valid(List<Integer> pos, int x, int y) {
        // int n = pos.size();
        // System.out.println(n);
        for (int i = 0; i < y; i++) {
            // row
            if (pos.get(i) == x) return false;
            // diagonal 
            if (pos.get(i) == x + y - i)
                return false; // need improve, some early cols don't need check
            // reverse diagonal
            if (pos.get(i) == x - y + i)
                return false; // need improve, some early cols don't need check
        }
        return true;
    }

    private void nQueensHelper(
        int n, List<List<String>> ans, List<Integer> pos
    ) {
        for (int i = 0; i < n; i++) {
            if (isValid(pos, i)) {
                pos.add(i);
                // System.out.println(pos);
                if (pos.size() == n) {
                    List<String> tmp_list = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        char[] tmp = new char[n];
                        Arrays.fill(tmp, '.');
                        tmp[pos.get(j)] = 'Q';
                        tmp_list.add(new String(tmp));
                    }
                    ans.add(tmp_list);
                    pos.remove(pos.size() - 1);
                    return;
                }
                nQueensHelper(n, ans, pos);
                pos.remove(pos.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> pos, int x) {
        int n = pos.size();
        // System.out.println(n);
        for (int i = 0; i < n; i++) {
            // row
            if (pos.get(i) == x) return false;
            // diagonal 
            if (pos.get(i) == x + n - i)
                return false;
            // reverse diagonal
            if (pos.get(i) == x - n + i)
                return false;
        }
        return true;
    }


    public static void main (String[] args) {
        NQueensJava test = new NQueensJava();
        System.out.println(test.solveNQueens(1));
        System.out.println(test.solveNQueens(3));
        System.out.println(test.solveNQueens(4));
        // System.out.println(test.solveNQueens(9));
        // System.out.println(test.is_valid(Arrays.asList(1, 3, null, null), 2, 0));
    }
}