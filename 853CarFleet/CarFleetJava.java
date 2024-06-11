import java.util.Arrays;

public class CarFleetJava {
    public int carFleet(
        int target, int[] position, int[] speed
    ) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; ++i) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // sort cars based on position reverse order
        Arrays.sort(
            cars,
            // new Comparator<int[]>() {
            //     @Override
            //     public int compare(int[] a, int[] b) {
            //         return b[0] - a[0];
            //     }
            // }
            (int[] a, int[] b) -> b[0] - a[0]
        );
        // for (int[] arr : cars) {
        //     System.out.println(Arrays.toString(arr));
        // }
        int ans = 0;
        double cur_arrive = 0;
        for (int[] arr : cars) {
            double arrive = 
                ((double)target - arr[0]) / arr[1];
            if (arrive > cur_arrive) {
                ans++;
                cur_arrive = arrive;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CarFleetJava test = new CarFleetJava();
        System.out.println(test.carFleet(
            10, new int[]{1, 4}, new int[]{3, 2}
        ));
    }
}
