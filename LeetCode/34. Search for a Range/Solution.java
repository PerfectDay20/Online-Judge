public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lower(nums, target);
        int right = upper(nums, target);
        if (left == right) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, right - 1};
        }
    }

    private int upper(int[] nums, int t) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= t) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }

    private int lower(int[] nums, int t) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}