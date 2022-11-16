package main

import "fmt"

func twoSum(nums []int, target int) []int {
	for i, value := range nums {
		for j := i + 1; j < len(nums); j++ {
			if value + nums[j] == target {
				return []int {i, j}
			}
			// fmt.Println([]int {i, j})
		}
	}
	return nil
}

func main() {
	fmt.Println(twoSum([]int{3, 26, 87, 2341, 4876, 23}, 2364))
}