public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) {//find first non-zero
                i++;
            }
            j = i + 1;
            while (j < nums.length && nums[j] == 0) {//find first zero
                j++;
            }
            if (j >= nums.length) {//to the end
                return;
            }
            swap(nums, i, j);//swap zero and non-zero
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}