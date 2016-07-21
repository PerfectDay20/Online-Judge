public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1}));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }
        return id;
    }
}