public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = (left + right) >>> 1;
        while (left < right) {
            if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                right = mid;
            } else if (left + 1 == right || (nums[left] - nums[mid]) * (nums[mid] - nums[right]) > 0) {
                
                return Math.min(nums[left], nums[right]);
            }
            mid = (left + right) >>> 1;
        }
        return nums[left];
    }

}