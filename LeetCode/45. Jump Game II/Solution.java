public class Solution {

    public int jump(int[] nums) {//O(N)
        if (nums.length < 2) {
            return 0;
        }
        int right = nums[0], last = nums[0], count = 1;
        for (int i = 1;; i++) {
            if (i == nums.length - 1) {
                return count;
            }
            right = Math.max(i + nums[i], right);
            if (i == last) {
                count++;
                last = right;
            }
        }
    }

    public int jump1(int[] nums) {//O(N2) Time Limit Exceed
        int[] least = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + nums[i] && j <= nums.length; j++) {
                if (j == nums.length - 1) {
                    return least[i] + 1;
                }
                if (least[j] == 0 || least[j] > least[i] + 1) {
                    least[j] = least[i] + 1;
                }
            }
        }
        return least[least.length - 1];
    }
}