

public class MedianofTwoSortedArraysJava {
    public double findMedianSortedArrays(int[] nums1,
                                        int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ansArray = new int[(m + n)];
        // if one array is empty
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2])
                                    / 2.0; 
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2])
                                    / 2.0; 
            } else {
                return nums1[m / 2];
            }
        }
        // merging
        int ct = 0, i = 0, j = 0;
        while(ct < (m + n)) {
            // if one array has ended
            if (i == m) {
                while(j < n){
                    ansArray[ct++] = nums2[j++];
                }
            }
            if (j == n) {
                while (i < m){
                    ansArray[ct++] = nums1[i++];
                }
            }
            // both arrrays still get elements
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    ansArray[ct++] = nums1[i++];
                } else {
                    ansArray[ct++] = nums2[j++];
                }
            }
        }
        if (ct % 2 == 0) {
            return (ansArray[ct / 2 - 1] + ansArray[ct / 2])
                                    / 2.0;
        } else {
            return ansArray[ct / 2];
        }
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3}, arr2 = new int[]{2};
        System.out.println(new MedianofTwoSortedArraysJava().
                        findMedianSortedArrays(arr1, arr2));
    }
}
