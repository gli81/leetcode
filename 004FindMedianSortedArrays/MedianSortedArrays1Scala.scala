

object MedianSortedArrays1Scala {
    def findMedianSortedArrays(nums1 : Array[Int], nums2 : Array[Int]) : Double = {
        val m : Int = nums1.length
        val n : Int = nums2.length
        var ct : Int = 0
        var i : Int = 0
        var j : Int = 0
        val arr : Array[Int] = new Array[Int](m + n)
        // one array is empty
        if (m == 0) return if (n % 2 != 0) nums2(n / 2) else (nums2(n / 2 - 1) + nums2(n / 2)) / 2.0 
        if (n == 0) return if (m % 2 != 0) nums1(m / 2) else (nums1(m / 2 - 1) + nums1(m / 2)) / 2.0 
        // merging
        while (ct < (m + n)) {
            // one array has ended
            if (i == m) {
                while(j < n){
                    arr(ct) = nums2(j)
                    ct += 1
                    j += 1
                }
            }
            if (j == n) {
                while(i < m) {
                    arr(ct) = nums1(i)
                    i += 1
                    ct += 1
                }
            }
            // both arrays still get elements
            if (i < m && j < n) {
                if (nums1(i) < nums2(j)) {
                    arr(ct) = nums1(i)
                    ct += 1
                    i += 1
                } else {
                    arr(ct) = nums2(j)
                    ct += 1
                    j += 1
                }
            }
        }
        return if(ct % 2 != 0) arr(ct / 2) else (arr(ct / 2 - 1) + arr(ct / 2)) / 2.0
    }
    def main(args : Array[String]) : Unit = {
        val arr1 : Array[Int] = Array(1, 23)
        val arr2 : Array[Int] = Array(2)
        println(findMedianSortedArrays(arr1, arr2))
    }
}