public class FirstBadVersionJava {
    public int firstBadVersion(int n, int bad) {
        int l = 1, r = n;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (isBadVersion(mid, bad)) {
                if (!isBadVersion(mid - 1, bad)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    public int firstBadVersion2(int n, int bad) {
        int l = 1, r = n;
        int mid = 0;
        while (l <= r) {
            // prevent integer overflow
            mid = l + (r - l) / 2;
            if (isBadVersion(mid, bad)) {
                if (!isBadVersion(mid - 1, bad)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }

    private boolean isBadVersion(int bad, int ans) {
        return bad == ans ? true : false;
    }


    public static void main(String[] args) {
        FirstBadVersionJava test = 
            new FirstBadVersionJava();
        System.out.println(test.firstBadVersion2(5, 4));
        System.out.println(test.firstBadVersion2(1, 1));
        System.out.println(test.firstBadVersion2(2, 2));
    }
}