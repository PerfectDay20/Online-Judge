import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sec = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]) - 1;
                    int secNo = i / 3 * 3 + j / 3;
                    if (row[i][val] || col[j][val] || sec[secNo][val]) {
                        return false;
                    }
                    row[i][val] = col[j][val] = sec[secNo][val] = true;
                }

            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {//row
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            set.clear();
        }
        for (int i = 0; i < 9; i++) {//column
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
            set.clear();
        }

        for (int i = 0; i <= 6; i += 3) {//section
            for(int j = 0; j<= 6; j+=3) {
                for(int m = 0; m <3; m++) {
                    for(int n= 0; n<3; n++) {
                        if (board[i + m][j + n] != '.') {
                            if (set.contains(board[i + m][j + n])) {
                                return false;
                            } else {
                                set.add(board[i + m][j + n]);
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;


    }
}