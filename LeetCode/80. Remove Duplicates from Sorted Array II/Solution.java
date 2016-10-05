public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1, j = 1, time = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j - 1]) {
                time = 1;
                nums[i++] = nums[j++];
            } else {
                if (++time == 2) {
                    nums[i++] = nums[j++];
                } else {
                    j++;
                }
            }
        }
        return i;
    }
    
}