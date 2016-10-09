public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int m, int n) {
        if (m < n) {
            return gcd(n, m);
        }
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
}