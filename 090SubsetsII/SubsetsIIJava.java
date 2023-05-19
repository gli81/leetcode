

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsIIJava {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets_helper(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void subsets_helper(int[] nums,
                                int start,
                                List<Integer> cur,
                                List<List<Integer>> ans) {
        ans.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            // if same as the one before
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            subsets_helper(nums, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
    

    public static void main(String[] args) {
        SubsetsIIJava test = new SubsetsIIJava();
        System.out.println(
            test.subsetsWithDup(new int[]{1, 2, 2})
        );
        System.out.println(
            test.subsetsWithDup(new int[]{0})
        );
    }
}
