

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class InsertIntervalJava{
    public static void main(String[] args) {
        InsertIntervalJava test = new InsertIntervalJava();
        System.out.println(
            test.insert(new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5})
        );
        System.out.println(
            test.insert(new int[][]{{1, 2}, {3, 5},
                                {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8})
        );

    }

    public int[][] insert(int[][] intervals,
                            int[] newInterval) {
        // System.out.println(Arrays.toString(newInterval));
        int start = -1;
        int end = -1;
        int new_start = newInterval[0];
        int new_end = newInterval[1];
        // why List<int[]> not List<List<Integer>>
        // https://www.techiedelight.com/zh/convert-int-array-integer-array-java/
        List<int[]> ans = new ArrayList<>();
        int index = 0;
        if (intervals.length == 0) {
            ans.add(newInterval);
            return ans.toArray(new int[0][]);
        }
        while (index < intervals.length &&
                intervals[index][1] < new_start) {
            ans.add(intervals[index++]);
        }
        // everything in intervals added
        // just add newInterval to the end
        if (index == intervals.length) {
            start = new_start;
            end = new_end;
        } else {
            start = Math.min(new_start, intervals[index][0]);
        }
        while (index < intervals.length && 
                intervals[index][0] <= new_end) {
            end = Math.max(
                Math.max(end, new_end), intervals[index][1]
            );
            index++;
        }

        if (end == -1) end = new_end;
        ans.add(new int[]{start, end});
        while (index < intervals.length) {
            ans.add(intervals[index]);
        }
        return ans.toArray(new int[0][]);
    }
}