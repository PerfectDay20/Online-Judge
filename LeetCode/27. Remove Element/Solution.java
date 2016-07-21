public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{1, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (true) {
            while (i <= j && nums[i] != val) {
                i++;
            }
            while (i <= j && nums[j] == val) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                break;
            }
        }
        return i;
    }
}