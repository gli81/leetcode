

public class GraphValidTreeJava {
    public boolean validTree(int n, int[][] edges) {
        return false;
    }


    public static void main(String[] args) {
        GraphValidTreeJava test = new GraphValidTreeJava();
        System.out.println(
            test.validTree(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
            })
        );
        System.out.println(
            test.validTree(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 4}
            })
        );
    }
}