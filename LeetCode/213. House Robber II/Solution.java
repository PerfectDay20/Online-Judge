public class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = helper(nums, 0, nums.length - 2);//1 ~ n-1 items
        int max2 = helper(nums, 1, nums.length - 1);//2 ~ n items
        return Math.max(max1, max2);
    }

    private int helper(int[] nums, int left, int right) {
        int a = nums[left], b = Math.max(nums[left], nums[left + 1]), c = b;
        for (int i = left+2; i <= right; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}