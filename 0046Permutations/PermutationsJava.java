

import java.util.List;
import java.util.ArrayList;

public class PermutationsJava {
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm2Helper(nums, ans, new ArrayList<Integer>());
        return ans;
    }

    private void perm2Helper(
        int[] nums, List<List<Integer>> ans, List<Integer> cur
    ) {
        if (nums.length == cur.size()) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                perm2Helper(nums, ans, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
