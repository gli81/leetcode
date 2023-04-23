

import java.util.Arrays;

public class SetMatrixZerosJava {
    public void setZeros(int[][] matrix) {
        boolean[] r_zeros = new boolean[matrix.length];
        boolean[] c_zeros = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    r_zeros[i] = true;
                    c_zeros[j] = true;
                }
            }
        }
        // rows
        for (int i = 0; i < matrix.length; i++) {
            if (r_zeros[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // cols
        for (int j = 0; j < matrix[0].length; j++) {
            if (c_zeros[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZerosJava test = new SetMatrixZerosJava();
        int[][] test1 = new int[][]{
            new int[]{1, 1, 1},
            new int[]{1, 0, 1},
            new int[]{1, 1, 1},
        };
        test.setZeros(test1);
        for (int[] arr : test1) {
            System.out.println(Arrays.toString(arr));
        }
        int[][] test2 = new int[][]{
            new int[]{0, 1, 2, 0},
            new int[]{3, 4, 5, 2},
            new int[]{1, 3, 1, 5},
        };
        test.setZeros(test2);
        for (int[] arr : test2) {
            System.out.println(Arrays.toString(arr));
        }
    }
}