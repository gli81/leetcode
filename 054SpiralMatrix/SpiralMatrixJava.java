
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixJava {
    public static void main(String[] args) {
        SpiralMatrixJava test = new SpiralMatrixJava();
        System.out.println(
            test.spiralOrder(new int[][] {{1, 2, 3},
                                        {4, 5, 6},
                                        {7, 8, 9}
                                    })
        );
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        
        return ans; 
    }
}