

public class MedianofTwoSortedArraysJava {
    public double findMedianSortedArrays1(
        int[] nums1,
        int[] nums2
    ) {
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
            return (
                ansArray[ct / 2 - 1] + ansArray[ct / 2]
            ) / 2.0;
        } else {
            return ansArray[ct / 2];
        }
    }

    /**
     * 
     * @param nums1 sorted array
     * @param nums2 sorted array
     * @return median of the two arrays merged
     */
    public double findMedianSortedArrays3(
        int[] nums1, int[] nums2
    ) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2, r = (m + n + 2) / 2;
        if (m + n == 0) return 0;
        if (m == 0) {
            return
                n % 2 == 0 ?
                (nums2[l - 1] + nums2[r - 1]) / 2.0 :
                (double)nums2[l - 1];
        }
        if (n == 0) {
            return
                m % 2 == 0 ?
                (nums1[l - 1] + nums1[r - 1]) / 2.0 :
                (double)nums1[l - 1];
        }
        int l1 = 0, l2 = 0, k = l;
        int median1, median2;
        while (true) {
            if (l1 == m) {
                median1 = nums2[l2 + k - 1];
                median2 = nums2[l2 + k + r - l - 1];
                break;
            }
            if (l2 == n) {
                median1 = nums1[l1 + k - 1];
                median2 = nums1[l1 + k + r - l - 1];
                break;
            }
            if (k == 1) {
                median1 = Math.min(nums1[l1], nums2[l2]);
                median2 = Math.min(
                    Math.max(
                        nums1[l1], nums2[l2]
                    ),
                    Math.min(
                        l1 + 1 < m ?
                            nums1[l1 + 1] :
                            Integer.MAX_VALUE,
                        l2 + 1 < n ?
                            nums2[l2 + 1] :
                            Integer.MAX_VALUE
                    )
                );
                break;
            }
            // none of the ending condition satisfied
            // advance
            // by how many?
            int advance1 = Math.min(k / 2, m - l1);
            int advance2 = Math.min(k / 2, n - l2);
            // which array to advance
            if (nums1[
                    l1 + advance1 - 1
                ] < nums2[
                    l2 + advance2 - 1
                ]
            ) {
                // advance nums1
                l1 += advance1;
                k -= advance1;
            } else {
                l2 += advance2;
                k -= advance2;
            }
        }
        return 
            (m + n) % 2 == 0 ?
            (median1 + median2) / 2.0 :
            (double)median1;
    }


    public static void main(String[] args) {
        MedianofTwoSortedArraysJava test =
            new MedianofTwoSortedArraysJava();
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{1, 3}, new int[]{2}
            )
        );
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{}, new int[]{2, 3}
            )
        );
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{3, 4}, new int[]{}
            )
        );
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{3},
                new int[]{2, 3, 4, 5, 6, 7, 8}
            )
        );
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{1, 2}, new int[]{2, 3}
            )
        );
        System.out.println(
            test.findMedianSortedArrays3(
                new int[]{1}, new int[]{2, 3, 4}
            )
        );
    }
}
