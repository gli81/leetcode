
import java.util.Arrays;

public class ProductofArrayExceptSelfJava {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[len - i - 1] = right[len - i] *
                nums[len - i];
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int[] ans = new int [len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    
    public static void main(String[] args) {
        ProductofArrayExceptSelfJava test = 
            new ProductofArrayExceptSelfJava();
        System.out.println(
            Arrays.toString(
                test.productExceptSelf(
                    new int[]{1, 2, 3, 4}
                )
            )
        );
        System.out.println(
            Arrays.toString(
                test.productExceptSelf(
                    new int[]{-1, 1, 0, -3, 3}
                )
            )
        );
    }
}