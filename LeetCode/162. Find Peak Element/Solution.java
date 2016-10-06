public class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid1 = (l + r) >>> 1, mid2 = mid1 + 1;
        if (nums[mid1] > nums[mid2]) {
            return search(nums, l, mid1);
        } else {
            return search(nums, mid2, r);
        }
    }


}