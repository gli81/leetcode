# -*- coding: utf-8 -*-

class RemoveElement:
    def removeElement(self, nums: list[int], val: int) -> int:
        '''
        returns the length of list with val removed
        '''
        if len(nums) == 0: return 0
        i = 0   ##index
        for j in range(len(nums)):
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1
        return i

def main():
    print(RemoveElement().removeElement([1, 1, 2], 1))
    print(RemoveElement().removeElement([3, 2, 2, 3], 3))

if __name__ == "__main__":
    main()
