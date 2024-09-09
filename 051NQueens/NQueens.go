package main

import (
	"fmt"
	"strings"
)

func solveNQueens(n int) [][]string {
	ans_ := []*[]string{}
	pos := []int{}
	backtrack(&pos, &ans_, 0, n)
	ans := [][]string{}
	for _, s := range ans_ {
		ans = append(ans, *(s))
	}
	return ans
}

func backtrack(pos *[]int, ans *[]*[]string, y int, n int) {
	for i := 0; i < n; i++ {
		if is_valid(*pos, i, y) {
			*pos = append(*pos, i)
			if len(*pos) == n {
				tmp_lst := []string{}
				// fmt.Println(*pos)
				for j := 0; j < n; j++ {
					tmp := strings.Repeat(
						".", (*pos)[j],
					) + "Q" + strings.Repeat(
						".", n-(*pos)[j]-1,
					)
					// fmt.Println(tmp)
					tmp_lst = append(tmp_lst, tmp)
				}
				*ans = append(*ans, &tmp_lst)
				*pos = (*pos)[:n-1]
				if n > 1 {
					*pos = (*pos)[:n-1]
				}
				return
			}
			backtrack(pos, ans, y+1, n)
		}
	}
	if y != 0 {
		*pos = (*pos)[:y-1]
	}
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
