import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        int t = 1;
        for (int i = 1; i <= n; i++) {
            if (t * t == i) {
                nums[i] = 1;
                t++;
            } else {
                int min = nums[i];
                for (int j = 1; j*j <= i; j++) {
                    min = Math.min(min, 1 + nums[i - j * j]);
                }
                nums[i] = min;
            }
        }
        return nums[n];
    }
}