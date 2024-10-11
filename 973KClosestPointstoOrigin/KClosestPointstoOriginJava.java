import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOriginJava {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] > b[0]) return 1;
                else if (a[0] == b[0]) return 0;
                else return -1;
            }
        );
        for (int[] p : points) {
            pq.add(
                new double[]{
                    Math.sqrt((double)p[0] * p[0] + p[1] * p[1]),
                    (double)p[0],
                    (double)p[1]
                }
            );
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; ++i) {
            double[] cur = pq.poll();
            ans[i][0] = (int)cur[1];
            ans[i][1] = (int)cur[2];
        }
        return ans;
    }


    public static void main(String[] args) {
        KClosestPointstoOriginJava test =
            new KClosestPointstoOriginJava();
        for (
            int[] r :test.kClosest(
                new int[][]{
                    {0, 2},
                    {2, 2}
                },
                1    
            )
        ) {
            System.out.println(Arrays.toString(r));
        }
    }
}
