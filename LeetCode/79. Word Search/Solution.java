public class Solution {
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] ^= 256;//change [i][j] to mark visited
        boolean ans = helper(i + 1, j, k + 1) || helper(i, j + 1, k + 1) || helper(i - 1, j, k + 1) || helper(i, j - 1, k + 1);
        board[i][j] ^= 256;
        return ans;
    }
}