// -*- coding: utf-8 -*-

package main

import "fmt"

func fib1(n int) int {
	if n < 2 {
		return n
	}
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = 1
	for i := 2; i < n+1; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[len(dp)-1]
}

func fib3(n int) int {
	if n < 2 {
		return n
	}
	ans := 0
	prev2 := 1
	prev := 0
	for i := 2; i <= n; i++ {
		ans = prev2 + prev
		prev = prev2
		prev2 = ans
	}
	return ans
}

func main() {
	fmt.Println(fib1(3))
}
