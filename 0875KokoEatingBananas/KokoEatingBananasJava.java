import java.util.Arrays;

public class KokoEatingBananasJava {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1,
            r = Arrays.stream(piles).max().getAsInt(),
            ans = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil((double)pile / k);
                if (time > h) break;
            }
            if (time > h) {
                // can't finish
                // increase k to eat faster
                l = k + 1;
            } else {
                // decrease k
                ans = k;
                r = k - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        KokoEatingBananasJava test = 
            new KokoEatingBananasJava();
        System.out.println(test.minEatingSpeed(
            new int[]{1, 4, 3, 2}, 9
        ));
    }
}
