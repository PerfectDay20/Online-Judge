import java.util.ArrayList;
import java.util.List;
//same method with 59. Spiral Matrix II
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row = 0, col = -1, m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        while (true) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[row][++col]);
            }
            if (--m <= 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                list.add(matrix[++row][col]);
            }
            if (--n <= 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                list.add(matrix[row][--col]);
            }
            if (--m <= 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                list.add(matrix[--row][col]);
            }
            if (--n <= 0) {
                break;
            }
        }
        return list;
    }
}