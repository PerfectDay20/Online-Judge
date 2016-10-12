public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("abc", "def"));
    }
    private String word1, word2;
    private int n1, n2;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        n1 = word1.length();
        n2 = word2.length();
        memo = new int[n1 + 1][n2 + 1];
        return solve(0, 0);
    }

    private int solve(int i, int j) {
        if (i == n1 || j == n2) {
            return Math.max(n1 - i, n2 - j);
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = solve(i + 1, j + 1);
        } else {
            memo[i][j] = 1 + Math.min(solve(i + 1, j), Math.min(solve(i, j + 1), solve(i + 1, j + 1)));
        }
        return memo[i][j];
    }
}