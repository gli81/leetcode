

class Sqrt:
    def mySqrt(self, x: "int") -> "int":
        '''
        binary search method
        '''
        left = 0
        right = x
        ans = 0
        while left <= right:
            mid = (left + right) // 2
            if mid ** 2 == x: return mid
            elif mid ** 2 < x:
                ## before exiting, set ans to left, which
                ## was ?????
                ans = left
                left = mid + 1
            else:
                ans = left - 1 ## left set to the last mid
                ## the proceeding mid was the last one to
                ## not square over x
                right = mid - 1
        return ans




def main():
    test = Sqrt()
    print(test.mySqrt(0))
    print(test.mySqrt(1))
    print(test.mySqrt(2))
    print(test.mySqrt(4))
    print(test.mySqrt(6))
    print(test.mySqrt(8))


if __name__ == "__main__":
    main()
