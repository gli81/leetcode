package main

import (
	"fmt"

	"golang.org/x/exp/constraints"
)

func main() {
	fmt.Println(minDistance("hello", "lllohe"))
	fmt.Println(min(1, 2))
}

func minDistance(word1 string, word2 string) int {
	// set up dp table
	m := len(word1)
	n := len(word2)
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
		dp[i][0] = i
	}
	// set up initial values
	// first column of dp is modifing empty to dest by far
	// set in previous line
	// first row of dp is modifing src by far to empty
	for i := range dp[0] {
		dp[0][i] = i
	}
	for i := 1; i < n+1; i++ {
		for j := 1; j < m+1; j++ {
			dp[i][j] = min(
				min(
					dp[i-1][j]+1,
					dp[i][j-1]+1,
				),
				dp[i-1][j-1]+map[bool]int{true: 1, false: 0}[!(word1[j-1] == word2[i-1])],
			)
		}
	}
	return dp[n][m]
}

func min[T constraints.Ordered](a, b T) T {
	if a < b {
		return a
	}
	return b
}
