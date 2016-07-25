public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = prices.length - 1; i >= 1; i--) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                sum += temp;
            }
        }
        return sum;
    }
}