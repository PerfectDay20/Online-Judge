public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] nums = new int[m + 1][n + 1];
        nums[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    nums[i][j] = nums[i + 1][j] + nums[i][j + 1];
                }
            }
        }
        return nums[0][0];
    }
}