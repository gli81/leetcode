
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberJava {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return -(s1 + s2).compareTo(s2 + s1);
            }
        }));
        // System.out.println(strs[0]);
        // deal with [0, 0]
        if (strs[0].equals("0")) return "0";
        return String.join("", strs);
    }

    public static void main(String[] args) {
        LargestNumberJava test =
            new LargestNumberJava();
        System.out.println(
            test.largestNumber(new int[]{10, 2})
        );
        System.out.println(
            test.largestNumber(
                new int[]{3, 30, 34, 5, 9}
            )
        );
        System.out.println(
            test.largestNumber(
                new int[]{0, 0}
            )
        );
    }
}