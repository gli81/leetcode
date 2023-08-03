

public class BestTimetoBuyandSellStockJava {
    /** brute force solution
     * exceeds time limit
     */
    public int maxProfit1(int[] prices) {
        int ans = 0;
        // brute force
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > ans) {
                    ans = prices[j] - prices[i];
                }
            }
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        // brute force
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > ans) {
                    ans = prices[j] - prices[i];
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        BestTimetoBuyandSellStockJava test =
            new BestTimetoBuyandSellStockJava();
        System.out.println(test.maxProfit2(
            new int[]{7, 1, 5, 3, 6, 4}
        ));
        System.out.println(test.maxProfit2(
            new int[]{7, 6, 4, 3, 1}
        ));
    }
}
