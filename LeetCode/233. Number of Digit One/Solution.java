public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        long k = 1;
        int ans = 0;
        while (n >= k) {
            long a = n / k / 10, b = n % k, digit = n / k % 10;
            if (digit >= 2) {
                ans += (1 + a) * k;
            } else if (digit == 1) {
                ans += a * k + (b + 1);
            } else {
                ans += a * k;
            }
            k *= 10;
        }
        return ans;
    }
}