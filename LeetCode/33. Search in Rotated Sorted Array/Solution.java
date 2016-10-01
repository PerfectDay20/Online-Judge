import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }//first find the rotate point, then do binary search
        }
        return Math.max(binarySearch(nums, 0, l - 2, target), binarySearch(nums, l-1, nums.length - 1, target));
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (l >= nums.length || r < 0 || nums[l] > target || nums[r] < target) {
            return -1;
        }
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {//another way
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && nums[m] >= target) {
                    return binarySearch(nums, l, m, target);
                } else {
                    l = m + 1;
                    continue;
                }
            }
            if (nums[m] <= nums[r]) {
                if (nums[m] <= target && target <= nums[r]) {
                    return binarySearch(nums, m, r, target);
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }


}