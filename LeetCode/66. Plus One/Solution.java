public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] == 9) {
                digits[i] = 0;
                i--;
            } else {
                digits[i]++;
                break;
            }
        }
        if (i == -1) {//if digits is 9999, then return 10000
            int[] nums = new int[digits.length + 1];
            System.arraycopy(digits, 0, nums, 1, digits.length);
            nums[0] = 1;
            return nums;
        }
        return digits;
    }
}