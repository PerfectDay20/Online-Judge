public class Solution {
    public int firstMissingPositive(int[] nums) {//O(n) space O(n) time
        int n = nums.length;
        int[] count = new int[n + 2];
        for (int i : nums) {
            if (i > 0 && i <= n) {
                count[i]++;
            }
        }
        for (int i = 1; i < n + 2; i++) {
            if (count[i] == 0) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    public int firstMissingPositive1(int[] nums) {//O(1) space O(n) time
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n == 0 ? 1 : n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}