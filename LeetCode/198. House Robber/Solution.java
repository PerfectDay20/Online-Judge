public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] c = new int[nums.length];
        c[0] = nums[0];
        c[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            c[i] = Math.max(c[i - 1], c[i - 2] + nums[i]);
        }
        return c[nums.length - 1];
    }
}