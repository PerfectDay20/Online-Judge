public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(new Solution().searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {//binary search
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {//the position may be mid
                right = mid;
            } else if (nums[mid] < target) {//the position can't be mid, but mid + 1
                left = mid + 1;
            }
        }
        return left;
    }
}