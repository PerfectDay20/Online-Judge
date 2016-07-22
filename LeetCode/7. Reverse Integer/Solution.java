public class Solution {
    public int reverse(int x) {
        int ans = 0;
        boolean flag = x >= 0;
        x = Math.abs(x);
        while (x > 0) {
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10 && flag || ans == Integer.MAX_VALUE && x > Integer.MAX_VALUE % 10 + 1) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return flag ? ans : -ans;
    }
}