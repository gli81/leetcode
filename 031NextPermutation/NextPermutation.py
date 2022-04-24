# -*- coding: utf-8 -*-

class NextPermutation:
    def nextPermutation(self, nums: list[int]) -> None:
        ## looking for the first un-desc element
        left = len(nums) - 2
        while left >= 0 and nums[left] >= nums[left + 1]:
            left -= 1
        ## end of loop
        ## left is where we need to place the new number
        if left == -1:
            ## whole array descending, reverse the list, and return
            nums.reverse()
            return
        
        ## looking for the swapping index
        ## going from right to left, the first larger than to-be-swapped
        right = len(nums) - 1
        while right >= 0 and nums[right] <= nums[left]:
            right -= 1
        ## end of loop
        ## right is the index f the new number
        ## doing the swap
        nums[left], nums[right] = nums[right], nums[left]
        # nums[left + 1:].reverse
        i = left + 1
        j = len(nums) - 1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        return

        

def main():
    test = NextPermutation()
    # test1 = [1, 2, 3]
    # test2 = [3, 2, 1]
    # test3 = [1, 1, 5]
    # test4 = [1]
    # test.nextPermutation(test1)
    # test.nextPermutation(test2)
    # test.nextPermutation(test3)
    # test.nextPermutation(test4)
    # print(test1)
    # print(test2)
    # print(test3)
    # print(test4)
    test5 = [1, 3, 2]
    test.nextPermutation(test5)
    print(test5)





if __name__ == "__main__":
    main()
