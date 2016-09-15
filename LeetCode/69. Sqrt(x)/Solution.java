public class Solution {
    private double EPS = 1e-8;
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double temp = 0, ans = 1;
        while (Math.abs(ans - temp) > EPS) {//newton's method
            temp = ans;
            ans = (ans * ans + x) / (2 * ans);
        }
        return (int)ans;
    }

}