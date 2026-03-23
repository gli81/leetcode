

import java.util.Arrays;

public class SurroundedRegionJava {
    /**
     * DFS from 'O' connected to the boarder
     * @param board
     */
    public void solve2(char[][] board) {
        int r = board.length;
        if (r == 0) return;
        int c = board[0].length;
        for (int i = 0; i < r; ++i) {
            if (board[i][0] == 'O') {
                capture(board, i, 0, r, c);
            }
            if (board[i][c - 1] == 'O') {
                capture(board, i, c - 1, r, c);
            }
        }
        for (int j = 1; j < c - 1; ++j) {
            if (board[0][j] == 'O') {
                capture(board, 0, j, r, c);
            }
            if (board[r - 1][j] == 'O') {
                capture(board, r - 1, j, r, c);
            }
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void capture(char[][]board, int i, int j, int r, int c) {
        if (i < 0 || j < 0 || i >= r || j >= c || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        // four directions
        capture(board, i + 1, j, r, c);
        capture(board, i - 1, j, r, c);
        capture(board, i, j + 1, r, c);
        capture(board, i, j - 1, r, c);
    }

    /**
     * Union find
     * @param board
     */
    public void solve3(char[][] board) {
        int r = board.length;
        if (r == 0) return;
        int c = board[0].length;
        DSU dsu = new DSU(r * c + 1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (board[i][j] != 'O') continue;
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    dsu.union(r * c, i * c + j);
                } else {
                    for (int[] dir : dirs) {
                        int new_r = i + dir[0], new_c = j + dir[1];
                        if (board[new_r][new_c] == 'O') {
                            dsu.union(i * c + j, new_r * c + new_c);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (!dsu.connected(r * c, i * c + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void printBoard(char[][] board) {
        for (char[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    public static void main(String[] args) {
        SurroundedRegionJava test = new SurroundedRegionJava();
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'X', 'O'},
        };
        test.solve3(board1);
        test.printBoard(board1);
    }
}


class DSU {
    int[] Parent, Size;


    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];
        for (int i = 0; i < n; ++i) {
            Parent[i] = i;
            Size[i] = i;
        }
    }


    public int find(int node) {
        if (Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (Size[pu] >= Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        } else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        return true;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}