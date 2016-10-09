public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(1));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int ans = 10, temp = 1;
        for (int i = 0; i < n - 1; i++) {
            temp *= 9 - i;
            ans += 9 * temp;
        }
        return ans;
    }
}