

import java.util.ArrayList;
import java.util.List;

public class CombinationsJava {
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        get_ans2(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void get_ans(int n, int k, List<List<Integer>> ans,
                        List<Integer> cur, int start) {
        if (cur.size() == k) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            get_ans(n, k, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    private void get_ans2(int n, int k, List<List<Integer>> ans,
                        List<Integer> cur, int start) {
        // greatly reduce time
        if (cur.size() == k) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; 
            i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            get_ans(n, k, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        CombinationsJava test = new CombinationsJava();
        System.out.println(test.combine1(4, 2));
        System.out.println(test.combine1(1, 1));
    }
}
