

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
        return new int[][]{{0, 0}};
    }
}