public class Solution {
    public int maxSubArray(int[] nums) {
        int maxH = nums[0], maxA = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxH = Math.max(maxH + nums[i], nums[i]);
            maxA = Math.max(maxA, maxH);
        }
        return maxA;
    }
}