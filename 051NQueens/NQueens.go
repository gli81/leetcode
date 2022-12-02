package main

import "fmt"

func solveNQueens(n int) [][]string {
	ans := [][]string{}
	backtrack([]int{}, ans, 0, n)
	return ans
}

func backtrace(pos []int, ans [][]string, y int, n int) {

}

func is_valid(pos []int, x int, y int) bool {
	for i := 0; i < y; i++ {
		if pos[i] == x {
			return false
		}
		if pos[i] == x+y-i {
			return false
		}
		if pos[i] == x-y+i {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(solveNQueens(1))
	fmt.Println(solveNQueens(3))
	fmt.Println(solveNQueens(4))
}
