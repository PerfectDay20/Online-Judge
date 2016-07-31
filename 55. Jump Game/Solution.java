public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int right = nums[0], i;
        for (i = 1; i <= right && i < nums.length; i++) {
            right = Math.max(right, i + nums[i]);
        }
        return i == nums.length;
    }
}