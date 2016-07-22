public class Solution {
    public int[][] generateMatrix(int n) {
        int count = 0;
        int row = 0, col = -1, m = n;
        int[][] ans = new int[n][n];
        while (true) {
            for (int i = 0; i < n; i++) {
                ans[row][++col] = ++count;
            }
            if (--m <= 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                ans[++row][col] = ++count;
            }
            if (--n <= 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                ans[row][--col] = ++count;
            }
            if (--m <= 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                ans[--row][col] = ++count;
            }
            if (--n <= 0) {
                break;
            }
        }
        return ans;
    }
}