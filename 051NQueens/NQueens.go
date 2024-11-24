package main

import (
	"fmt"
	"strings"
)

func solveNQueens(n int) [][]string {
	ans := [][]string{}
	pos := []int{}
	nQueensHelper(&pos, &ans, 0, n)
	// ans := [][]string{}
	// for _, s := range ans_ {
	// 	ans = append(ans, *(s))
	// }
	return ans
}

func nQueensHelper(pos *[]int, ans *[][]string, y int, n int) {
	for i := 0; i < n; i++ {
		if isValid(*pos, i) {
			*pos = append(*pos, i)
			// fmt.Println(pos)
			if len(*pos) == n {
				tmp_lst := []string{}
				// fmt.Println(pos)
				for j := 0; j < n; j++ {
					tmp := strings.Repeat(
						".", (*pos)[j],
					) + "Q" + strings.Repeat(
						".", n-(*pos)[j]-1,
					)
					// fmt.Println(tmp)
					tmp_lst = append(tmp_lst, tmp)
				}
				// tmp_lst_2 := make([]string, len(tmp_lst))
				// _ = copy(tmp_lst_2, tmp_lst)
				*ans = append(*ans, tmp_lst)
				*pos = (*pos)[:len(*pos)-1]
				// if n > 1 {
				// 	*pos = (*pos)[:n-2]
				// }
				return
			}
			// pos_copy := make([]int, len(pos))
			// _ = copy(pos_copy, pos)
			nQueensHelper(pos, ans, y+1, n)
			*pos = (*pos)[:len(*pos)-1]
			// if y != 0 {
			// 	*pos = *pos[:y-1]
			// }
		}
	}
	// if y != 0 {
	// 	*pos = (*pos)[:y-1]
	// }
}

func isValid(pos []int, x int) bool {
	// fmt.Println("inside is_valid:", pos, "x:", x, "y:", y)
	n := len(pos)
	for i := 0; i < len(pos); i++ {
		if pos[i] == x {
			// fmt.Println(append(pos, x), " not valid")
			return false
		}
		if pos[i] == x+n-i {
			// fmt.Println(append(pos, x), " not valid")
			return false
		}
		if x-n+i >= 0 && pos[i] == x-n+i {
			// fmt.Println(append(pos, x), " not valid")
			return false
		}
	}
	// fmt.Println(append(pos, x), " VALID")
	return true
}

func main() {
	fmt.Println(solveNQueens(1))
	fmt.Println(solveNQueens(3))
	fmt.Println(solveNQueens(4))
	// fmt.Println(solveNQueens(6))
	// fmt.Println(solveNQueens(9))
}
