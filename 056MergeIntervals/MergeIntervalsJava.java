
public class MergeIntervalsJava {
    public static void main(String[] args) {
        MergeIntervalsJava test = new MergeIntervalsJava();
        System.out.println(
            test.merge(new int[][]{{1, 3}, {2, 6},
                                    {8, 10}, {15, 18}})
        );
    }

    public int[][] merge(int[][] intervals) {
        return new int[][]{{0, 0}};
    }
}