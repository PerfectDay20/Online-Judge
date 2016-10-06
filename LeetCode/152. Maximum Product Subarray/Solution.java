public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{-4, -3, -2}));
    }
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxA = nums[0], maxH = nums[0], minH = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0) {
                maxH = Math.max(maxH * nums[i], nums[i]);
                minH = Math.min(minH * nums[i], nums[i]);
            } else {
                int temp = maxH;
                maxH = Math.max(minH * nums[i], nums[i]);
                minH = Math.min(temp * nums[i], nums[i]);
            }
            maxA = Math.max(maxA, maxH);
        }
        return maxA;
    }
}