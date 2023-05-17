

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsIIJava {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets_helper(nums, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void subsets_helper(int[] nums,
                                List<Integer> cur,
                                List<List<Integer>> ans) {
        
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
