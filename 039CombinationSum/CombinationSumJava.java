import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumJava {
    public static void main(String[] args) {
        CombinationSumJava test = new CombinationSumJava();
        System.out.println(test.combSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combSum(int[] candidates, int target) {
        // List<Integer> cds = Arrays.asList(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combSum_(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void combSum_(List<List<Integer>> ans, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain == 0) ans.add(new ArrayList<Integer>(current));
        else if (remain < 0) return;
        else {
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                combSum_(ans, current, candidates, remain - candidates[i], i);
                current.remove(current.size() - 1);
            }
        }
    }
}