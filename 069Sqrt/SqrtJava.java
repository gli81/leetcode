

public class SqrtJava {
    /**
     * Binary search method
     * 
     * over time limit lah :D
     * @param x find its square root
     * @return the square root, to the closet integer
     */
    public int mySqrt1(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int sq = mid * mid;
            if (sq == x) return mid;
            else if (sq < x) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
    
    /**
     * Binary search method
     * @param x find its square root
     * @return the square root, to the closet integer
     */
    public int mySqrt2(int x) {
        int l = 0, r = x, ans = 0;
        if (x == 0) return 0;
        if (x == 1) return 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            // not over time limit this time :D
            int div = x / mid;
            if (mid == div) return mid;
            else if (mid < div) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        SqrtJava test = new SqrtJava();
        System.out.println(test.mySqrt2(4));
        System.out.println(test.mySqrt2(8));
    }
}