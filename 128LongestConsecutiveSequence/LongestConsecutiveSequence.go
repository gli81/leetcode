package main

func longestConsecutive(nums []int) int {
	// set
	record := make(map[int]struct{})
	for _, num := range nums {
		record[num] = struct{}{}
	}
	maxx := 0
	for num := range record {
		if _, ok := record[num-1]; !ok {
			tryIt := num
			count := 0
			_, exists := record[tryIt]
			for exists {
				tryIt++
				count++
				_, exists = record[tryIt]
			}
			maxx = max(maxx, count)
		}
	}
	return maxx
}
