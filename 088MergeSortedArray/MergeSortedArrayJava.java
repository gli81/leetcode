

import java.util.Arrays;

public class MergeSortedArrayJava {
    /**
     * 
     * @param nums1
     * @param nums2
     * @param n length of nums2
     */
    public void merge(int[] nums1, int[] nums2, int n) {
        /*
         * a step of merge sort
         */

    }
    

    public static void main(String[] args) {
        MergeSortedArrayJava test = new MergeSortedArrayJava();
        int[] test0101 = new int[]{1, 2, 3, 0, 0, 0};
        int[] test0102 = new int[]{2, 5, 6};
        test.merge(test0101, test0102, 3);
        System.out.println(Arrays.toString(test0101));
        int[] test0201 = new int[]{1};
        int[] test0202 = new int[]{};
        test.merge(test0201, test0202, 0);
        System.out.println(Arrays.toString(test0201));
        int[] test0301 = new int[]{0};
        int[] test0302 = new int[]{1};
        test.merge(test0301, test0302, 1);
        System.out.println(Arrays.toString(test0301));
    }
}
