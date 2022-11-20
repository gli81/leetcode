
import java.util.List;
import java.util.ArrayList;

public class NQueens {
    public static void main (String[] args) {
        NQueens test = new NQueens();
        System.out.println(test.solveNQueens(1));
        System.out.println(test.solveNQueens(3));
        System.out.println(test.solveNQueens(9));
    }

    public List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<List<String>>();
        backtrack(ans, n);
        return ans;
    }

    private void backtrack(List<List<String>> ans, int n) {

    }
}