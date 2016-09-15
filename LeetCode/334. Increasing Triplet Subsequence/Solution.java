public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= left) {
                left = i;
            } else if (i <= right) {
                right = i;
            } else{
                return true;
            }
        }
        return false;
    }
}