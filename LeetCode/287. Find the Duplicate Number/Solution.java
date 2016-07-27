public class Solution {
    public int findDuplicate(int[] nums) {
        int min = 1, max = nums.length - 1;
        while (min < max) {
            int mid = (min + max) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {//only one number duplicates
                max = mid;
            } else {//if count == mid, the duplicates larger than mid
                min = mid + 1;
            }
        }
        return min;
    }

}