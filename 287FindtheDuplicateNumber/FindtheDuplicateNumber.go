package main

import "fmt"

func findDuplicate2(nums []int) int {
	set := map[int]struct{}{}
	for _, num := range nums {
		if _, ok := set[num]; ok {
			return num
		} else {
			set[num] = struct{}{}
		}
	}
	return -1
}

func findDuplicate5(nums []int) int {
	slow := 0
	fast := 0
	slow = nums[slow]
	fast = nums[nums[fast]]
	for slow != fast {
		slow = nums[slow]
		fast = nums[nums[fast]]
	}
	slow2 := 0
	for slow2 != slow {
		slow = nums[slow]
		slow2 = nums[slow2]
	}
	return slow
}

func main() {
	fmt.Println(findDuplicate5([]int{1, 2, 3, 2, 2}))
}
