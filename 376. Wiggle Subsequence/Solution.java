public class Solution {
    public int wiggleMaxLength(int[] nums) {//O(N) greedy
        if (nums.length < 2) {
            return nums.length;
        }
        int lastSign = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap > 0 && lastSign <= 0) {
                count++;
                lastSign = 1;
            } else if (gap < 0 && lastSign >= 0) {
                count++;
                lastSign = -1;
            }
        }
        return count;
    }

    public int wiggleMaxLength2(int[] nums) {//DP O(N)
    if (nums.length < 2) {
        return nums.length;
    }
    int up = 1, down = 1;
    for (int i = 1; i < nums.length; i++) {
        int gap = nums[i] - nums[i - 1];
        if (gap > 0) {
            down = up + 1;
        } else if (gap < 0) {
            up = down + 1;
        }
    }
    return Math.max(up, down);
}

    public int wiggleMaxLength1(int[] nums) {//DP O(N2)
        if (nums.length < 2) {
            return nums.length;
        }
        int[] max = new int[nums.length];
        int[] sign = new int[nums.length];
        sign[1] = nums[1] > nums[0] ? 1 : -1;

        max[0] = 1;
        if (nums[1] == nums[0]) {
            max[1] = 1;
        } else {
            max[1] = 2;
        }
        int ans = max[1];
        for(int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && sign[j]<=0 && max[j] + 1 > max[i]) {
                    max[i] = max[j] + 1;
                    sign[i] = 1;
                } else if (nums[i] < nums[j] && sign[j]>=0 && max[j] + 1 > max[i]) {
                    max[i] = max[j] + 1;
                    sign[i] = -1;
                }
            }
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
