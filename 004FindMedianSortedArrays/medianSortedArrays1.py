# -*- coding: utf-8 -*-

class MedianSortedArrays1:
    ## solution 1: part of merge sort, merging two sorted sublist
    def findMedianSortedArrays(self, nums1 : list[int], nums2 : list[int]) -> float:
        '''
        params: two SORTED lists
        '''
        m = len(nums1)
        n = len(nums2)
        ansList = []
        ## if one list is empty
        if m == 0:
            return nums2[n // 2] if n % 2 != 0 else (nums2[n // 2 - 1] + nums2[n // 2]) / 2
        if n == 0:
            return nums1[m // 2] if m % 2 != 0 else (nums1[m // 2 - 1] + nums1[m // 2]) / 2
        
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
            
        return ansList[ct // 2] if ct % 2 != 0 else (ansList[ct // 2 - 1] + ansList[ct // 2]) / 2

def main():
    l1 = [1, 3]
    l2 = [2]
    print(MedianSortedArrays1().findMedianSortedArrays(l1, l2))

if __name__=='__main__':
    main()