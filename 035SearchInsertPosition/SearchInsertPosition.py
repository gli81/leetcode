

class SearchInsertPosition:
    def searchInsert(self, nums: list[int], target: int)-> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                ## target in the array, return the index
                # print("in loop")
                # return [left, mid, right]
                return mid
            elif nums[mid] < target: left = mid + 1
            else: right = mid - 1
        # return [left, mid, right]
        ## didn't return anything in the loop
        ## not in array
        return right + 1

def main():
    test = SearchInsertPosition()
    print(test.searchInsert([3, 5, 7, 9], 2))
    print(test.searchInsert([3, 5, 7, 9], 3))
    print(test.searchInsert([3, 5, 7, 9], 5))
    print(test.searchInsert([3, 5, 7, 9], 6))
    print(test.searchInsert([3, 5, 7, 9], 8))
    print(test.searchInsert([3, 5, 7, 9], 9))
    print(test.searchInsert([3, 5, 7, 9], 10))
    print("=" * 50)
    print(test.searchInsert([1, 3, 5, 6], 5))
    print(test.searchInsert([1, 3, 5, 6], 2))
    print(test.searchInsert([1, 3, 5, 6], 7))
    print(test.searchInsert([1, 3, 5, 6], 0))
    print(test.searchInsert([1], 0))

if __name__ == "__main__":
    main()