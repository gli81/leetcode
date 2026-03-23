

import java.util.List;
import java.util.ArrayList;

public class SubsetsJava {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        get_ans(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void get_ans(int[] nums, List<List<Integer>> ans,
                        List<Integer> cur, int start) {
        ans.add(new ArrayList<Integer>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            get_ans(nums, ans, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsJava test = new SubsetsJava();
        System.out.println(test.subsets1(new int[]{1, 2, 3}));
        System.out.println(test.subsets1(new int[]{0}));
    }
}
