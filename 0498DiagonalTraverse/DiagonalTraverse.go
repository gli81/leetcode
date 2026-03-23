package main

func findDiagonalOrder(mat [][]int) []int {
	m := len(mat)
	n := len(mat[0])
	ct := 0
	ans := make([]int, m*n)
	for i := 0; i < m+n-1; i++ {
		var min_, x, y int
		if i%2 == 0 {
			min_ = min(i, m-1)
			x = min_
			y = i - min_
			for x >= 0 && y < n {
				ans[ct] = mat[x][y]
				ct++
				x--
				y++
			}
		} else {
			min_ = min(i, n-1)
			x = i - min_
			y = min_
			for x < m && y >= 0 {
				ans[ct] = mat[x][y]
				ct++
				x++
				y--
			}
		}
	}
	return ans
}
