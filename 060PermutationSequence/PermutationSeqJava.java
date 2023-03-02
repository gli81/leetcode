

import java.util.List;
import java.util.ArrayList;

public class PermutationSeqJava {

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();;
        for (int i = 0; i < n; i++) nums.add(i + 1);
        return get_ans(nums, n, k);
    }

    private String get_ans(List<Integer> nums, int n, int k) {
        if (nums.size() == 1) return nums.get(0) + "";
        int len_group = factorial(n - 1);
        int group = (k - 1) / len_group;
        int num = nums.get(group);
        nums.remove(group);
        k = k % len_group;
        /*
         * index -1 out of bound
         * if k = 0 here, in the next recursion
         * group = -1 / len_group = -1
         * nums.get(-1) leads to IndexException
         * so if k = 0, change it to len_group
         */
        k = k ==  0 ? len_group : k;
        return num + get_ans(nums, n - 1, k);
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        PermutationSeqJava test = new PermutationSeqJava();
        System.out.println(
            test.getPermutation(3, 1)
        );
        System.out.println(
            test.getPermutation(3, 3)
        );
        System.out.println(
            test.getPermutation(4, 9)
        );
    }
}