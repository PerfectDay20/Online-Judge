public class Solution {
    public int maximalSquare(char[][] matrix) {//DP O(mn)
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0, pre = 0;
        int[] nums = new int[matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int temp = nums[j];
                if (matrix[i - 1][j - 1] == '1') {
                    nums[j] = Math.min(Math.min(nums[j - 1], nums[j]), pre);
                    max = Math.max(nums[j], max);
                } else {
                    nums[j] = 0;
                }
                pre = temp;
            }
        }
        return max * max;
    }

    public int maximalSquare1(char[][] matrix) {//brute force O(m*n*max(m,n))
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int up = i == 0 ? 0 : temp[i - 1][j];
                int left = j == 0 ? 0 : temp[i][j - 1];
                int corner = i == 0 || j == 0 ? 0 : temp[i - 1][j - 1];
                temp[i][j] = up + left + Character.getNumericValue(matrix[i][j]) - corner;
            }
        }
        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                for (int k = 0; k + i < temp.length && k + j < temp[0].length; k++) {
                    int up = i == 0 ? 0 : temp[i - 1][j + k];
                    int left = j == 0 ? 0 : temp[i + k][j - 1];
                    int corner = i == 0 || j == 0 ? 0 : temp[i - 1][j - 1];
                    int area = temp[i + k][j + k] - up - left + corner;
                    if (area == (k + 1) * (k + 1) && area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }
}