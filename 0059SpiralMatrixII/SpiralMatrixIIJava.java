

import java.util.Arrays;

public class SpiralMatrixIIJava {
    public static void main(String[] args) {
        SpiralMatrixIIJava test = new SpiralMatrixIIJava();
        for (int[] arr : test.generateMatrix(3)) {
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr : test.generateMatrix(1)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0, y = 0, top_b = 0, left_b = 0;
        int bottom_b = n - 1, right_b = n - 1;
        int num = 1;
        char dir = 'r';
        while (num <= n * n) {
            ans[x][y] = num++;
            switch (dir) {
                case 'r':
                    if (y < right_b) y++;
                    else {
                        x++;
                        dir = 'd';
                        top_b++;
                    }
                    break;
                case 'd':
                    if (x < bottom_b) x++;
                    else {
                        y--;
                        dir = 'l';
                        right_b--;
                    }
                    break;
                case 'l':
                    if (y > left_b) y--;
                    else {
                        x--;
                        dir = 'u';
                        bottom_b--;
                    }
                    break;
                case 'u':
                    if (x > top_b) x--;
                    else {
                        y++;
                        dir = 'r';
                        left_b++;
                    }
                    break;
            }
        }
        return ans;
    }
}