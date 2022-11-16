public class Pow {
    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(test.my_pow1(2.0, 10));
    }

    public double my_pow1(double x, int n) {
        if (x == 1.0) return 1;
        if (x == -1.0) {
            if ((n & 1) != 0) return -1.0; // n is odd
            else return 1.0;
        }
        if (n == -2147483648) return 0;
        double ans = 1;
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        if (neg) return 1 / ans;
        else return ans;
    }
}