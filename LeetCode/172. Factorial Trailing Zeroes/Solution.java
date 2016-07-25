public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;//the ans is n/5 + n/25 + n/125 + ...
        int t = 5;
        while (t <= n) {
            sum += n / t;
            n /= 5;
        }
        return sum;
    }
}