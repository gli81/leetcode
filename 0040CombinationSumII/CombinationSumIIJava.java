import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIIJava { 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combSum2_(ans, candidates, new ArrayList<Integer>(), target, 0);
        return ans;
    }
    
    private void combSum2_(
        List<List<Integer>> ans,
        int[] candidates,
        List<Integer> current,
        int remain,
        int start
    ) {
        if (remain == 0) ans.add(new ArrayList<Integer>(current));
        else if (remain < 0) return;
        else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                current.add(candidates[i]);
                combSum2_(ans, candidates, current, remain - candidates[i], i + 1);
                current.remove(current.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        CombinationSumIIJava test = new CombinationSumIIJava();
        System.out.println(test.combinationSum2(
            new int[]{10, 1, 2, 7, 6, 1, 5}, 8)
        );
    }
}
