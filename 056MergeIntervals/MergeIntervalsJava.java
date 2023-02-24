
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervalsJava {
    public static void main(String[] args) {
        MergeIntervalsJava test = new MergeIntervalsJava();
        int[][] rslt1 = test.merge2(
            new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
        );
        for (int[] arr : rslt1) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // sort
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return a[0] > b[0] ? 1 : a[0] == b[0] ? 0 : 1;
        //     }
        // });
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        if (intervals.length == 0) {
            return ans.toArray(new int[0][]);
        }
        int cur_left = intervals[0][0];
        int cur_right = intervals[0][1];
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            // System.out.println(Arrays.toString(intervals[i]));
            // new left > current right
            // add new one to the right
            if (cur_right < intervals[i][0]) {
                add_array(intervals[i][0], intervals[i][1], ans);
                cur_left = intervals[i][0];
                cur_right = intervals[i][1];
            } else {
                if (intervals[i][1] >= cur_right) {
                    ans.remove(ans.size()-1);
                    add_array(cur_left, intervals[i][1], ans);
                    cur_right = intervals[i][1];
                    
                }
            }
        }
        /*
         * List<int[]> to int[][]
         * https://www.cxyzjd.com/article/liqi299616/110420540
         * 
         */
        return ans.toArray(new int[0][]);
        // return new int[][]{{0, 0}};
    }

    private void add_array(int left, int right,
                            List<int[]> ans) {
        int arr[] = new int[]{left, right};
        ans.add(arr);
    }
}