

public class Search2DMatrixJava {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = matrix[mid / cols][mid % cols];
            if (temp == target) return true;
            else if (temp < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixJava test = new Search2DMatrixJava();
        System.out.println(test.searchMatrix(
            new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
            }, 3)
        );
        System.out.println(test.searchMatrix(
            new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50}
            }, 13)
        );
        
    }
}