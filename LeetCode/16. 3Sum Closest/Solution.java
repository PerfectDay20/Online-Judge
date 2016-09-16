import java.util.Arrays;

public class Solution {
    public int threeSumClosest1(int[] nums, int target) {//O(N^2)
        Arrays.sort(nums);
        int n = nums.length, ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
    public int threeSumClosest(int[] nums, int target) { //O(N^3)
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(temp - target) < Math.abs(ans - target)) {
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }
}