# -*- coding: utf-8 -*-

from typing import List

class MedianofTwoSortedArrays:
    def findMedianSortedArrays1(
        self,
        nums1 : "List[int]",
        nums2 : "List[int]"
    ) -> "float":
        """ Solution1: part of merge sort,
        merging two sorted sublist first
        Args:
            nums1 sorted list\n
            nums2 sorted list
        Returns:
            the median of the two lists merged
        Raises:
            NONE
        """
        m = len(nums1)
        n = len(nums2)
        ansList = []
        ## if one list is empty
        if m == 0:
            return nums2[n // 2] if n % 2 != 0 \
                else (nums2[n // 2 - 1] + nums2[n // 2]) / 2
        if n == 0:
            return nums1[m // 2] if m % 2 != 0\
                else (nums1[m // 2 - 1] + nums1[m // 2]) / 2
        
        ## merging part
        ct = i = j = 0
        while ct < (m + n):
            ## one list ended
            if i == m:
                while j < n:
                    ansList.append(nums2[j])
                    ct += 1
                    j += 1
                # break
            if j == n:
                while i < m:
                    ansList.append(nums1[i])
                    ct += 1
                    i += 1
                # break
            ## both lists still have elements in it
            if i < m and j < n:
                if nums1[i] < nums2[j]:
                    ansList.append(nums1[i])
                    ct += 1
                    i += 1
                else:
                    ansList.append(nums2[j])
                    ct += 1
                    j += 1
            
        return ansList[ct // 2] if ct % 2 != 0 \
            else (
                ansList[ct // 2 - 1] + ansList[ct // 2]
            ) / 2

    def findMedianSortedArrays3(
        self,
        nums1: "List[int]",
        nums2: "List[int]"
    ) -> "float":
        """
        Args:
            nums1 sorted list\n
            nums2 sorted list
        Returns:
            the median of two lists merged
        Raises:
            NONE
        """
        m = len(nums1)
        n = len(nums2)
        ## two elements used to calculate median
        ## 8 => 4, 7 => 4
        l = (m + n + 1) // 2
        ## 8 => 5, 7 => 4
        r = (m + n + 2) // 2
        if m + n == 0: return 0
        if m == 0:
            return (
                nums2[l - 1] + nums2[r - 1]
            ) / 2.0 if n % 2 == 0\
            else nums2[l - 1]
        if n == 0:
            return (
                nums1[l - 1] + nums1[r - 1]
            ) / 2.0 if m % 2 == 0\
            else nums1[l - 1]
        l1, l2 = 0, 0 ## excluded
        k = l
        while True:
            if l1 == m:
                median1 = nums2[l2 + k - 1]
                median2 = nums2[
                    l2 + k + r - l - 1
                ]
                break
            if l2 == n:
                median1 = nums1[l1 + k - 1]
                median2 = nums1[
                    l1 + k + r - l - 1
                ]
                break
            if k == 1:
                median1 = min(nums1[l1], nums2[l2])
                median2 = min(
                    max(
                        nums1[l1],
                        nums2[l2]
                    ), 
                    nums1[l1 + 1] if l1 + 1 < m\
                    else float('inf'),
                    nums2[l2 + 1] if l2 + 1 < n\
                    else float('inf')
                )
                break
            ## advance by how many
            mid1 = l1 + min(k // 2, m - l1)
            mid2 = l2 + min(k // 2, n - l2)
            if nums1[mid1 - 1] <= nums2[mid2 - 1]:
                k -= (mid1 - l1) ## how many excluded
                l1 = mid1
            else:
                k -= (mid2 - l2)
                l2 = mid2
        if (m + n) % 2 == 0:
            return (median1 + median2) / 2.0
        else:
            return float(median1)


def main():
    test = MedianofTwoSortedArrays()
    print(test.findMedianSortedArrays3(
        [1, 2], [3]
    ))
    print(test.findMedianSortedArrays3(
        [], [2, 3]
    ))
    print(test.findMedianSortedArrays3(
        [3, 4], []
    ))
    print(test.findMedianSortedArrays3(
        [3, ], [2, 3, 4, 5, 6, 7, 8]
    ))
    print(test.findMedianSortedArrays3(
        [1, 2], [2, 3]
    ))
    print(test.findMedianSortedArrays3(
        [1], [2, 3, 4]
    ))

if __name__ == "__main__":
    main()