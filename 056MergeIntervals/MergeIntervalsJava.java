
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MergeIntervalsJava {
    public static void main(String[] args) {
        MergeIntervalsJava test = new MergeIntervalsJava();
        int[][] rslt1 = test.merge(new int[][]{{1, 3}, {2, 6},
                                    {8, 10}, {15, 18}});
        for (int[] arr : rslt1) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // if (intervals.length == 0) return ans.toArray();
        ans.add(intervals[0]);
        // for (int i = 0; i < ans.size(); i++){
        //     System.out.println(Arrays.toString(ans.get(i)));
        // }
        /*
         * List<int[]> to int[][]
         * https://www.cxyzjd.com/article/liqi299616/110420540
         * 
         */
        return ans.toArray(new int[0][]);
        // return new int[][]{{0, 0}};
    }
}