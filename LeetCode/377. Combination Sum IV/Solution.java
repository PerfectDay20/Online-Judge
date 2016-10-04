import java.util.Arrays;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] ans = new int[target + 1];
        Arrays.sort(nums);
        for (int i = 0; i <= target; i++) {
            for (int n : nums) {
                if (n > i) {
                    break;
                } else if (n == i) {
                    ans[i]++;
                } else {
                    ans[i] += ans[i - n];
                }
            }
        }
        return ans[target];
    }
}