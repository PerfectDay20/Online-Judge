public class Solution {
    public int[] countBits(int num) {
        int[] nums = new int[num + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + 1;
            }
        }
        return nums;
    }
}