import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] temp = new int[n];
        int[] rank = new int[n + 1];
        Arrays.fill(rank, Integer.MAX_VALUE);
        rank[0] = Integer.MIN_VALUE;
        rank[1] = nums[0];
        temp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int index = Arrays.binarySearch(rank, nums[i]);
            if (index < 0) {
                index = -index - 1;
                temp[i] = index;
                rank[index] = nums[i];
                max = Math.max(max, index);
            }
        }
        return max;
    }
}