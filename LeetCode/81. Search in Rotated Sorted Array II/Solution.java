public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) >>> 1;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] > nums[left]) {
            if (nums[left] <= target && target <= nums[mid]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }
        if (nums[mid] < nums[right]) {
            if (nums[mid] <= target && target <= nums[right]) {
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        }
        return search(nums, left, mid - 1, target) || search(nums, mid + 1, right, target);
    }
}