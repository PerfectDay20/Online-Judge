public class Solution {
    private int m, n;
    private int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = check(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2) {
                        board[i][j] = 2;
                    } else if (count == 2 || count == 3) {
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 4;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 5;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2 || board[i][j] == 4) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3 || board[i][j] == 5) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int check(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nx = i + x[k], ny = j + y[k];
            if (reachable(nx, ny)) {
                if (1 <= board[nx][ny] && board[nx][ny] <= 4) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean reachable(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n;
    }
}