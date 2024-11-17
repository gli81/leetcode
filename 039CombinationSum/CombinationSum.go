package main

func combinationSum(candidates []int, target int) [][]int {
	ans := make([][]int, 0)
	cur := make([]int, 0)
	combHelper(candidates, target, &ans, cur, 0)
	return ans
}

func combHelper(
	candidates []int,
	target int,
	ans *[][]int,
	cur []int,
	idx int,
) {
	if target < 0 {
		return
	}
	if target == 0 {
		temp := make([]int, len(cur))
		copy(temp, cur)
		*ans = append(*ans, temp)
		return
	}
	for i := idx; i < len(candidates); i++ {
		// cur = append(cur, candidates[i])
		combHelper(
			candidates,
			target-candidates[i],
			ans,
			append(cur, candidates[i]),
			idx,
		)
	}
}
