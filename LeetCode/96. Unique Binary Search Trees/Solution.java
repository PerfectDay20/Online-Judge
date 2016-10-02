public class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++) {
            int j = i - 1;
            while (j >= 0) {
                nums[i] += nums[j] * nums[i - 1 - j];
                j--;
            }
        }
        return nums[n];
    }
}