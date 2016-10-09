public class Solution {
    private int[][] memo;
    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        return maxmin(1, n);
    }

    private int maxmin(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != 0) {
            return memo[l][r];
        }
        int ans = Integer.MAX_VALUE, temp = 0;
        for (int i = l; i <= r; i++) {
            temp = Math.max(maxmin(l, i - 1), maxmin(i + 1, r)) + i;
            ans = Math.min(ans, temp);
        }
        memo[l][r] = ans;
        return ans;
    }
}