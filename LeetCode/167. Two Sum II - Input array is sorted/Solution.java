public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        ans[1] = numbers.length - 1;
        while (true) {
            int sum = numbers[ans[0]] + numbers[ans[1]];
            if (sum > target) {
                ans[1]--;
            } else if (sum < target) {
                ans[0]++;
            } else {
                break;
            }
        }
        ans[0]++;
        ans[1]++;
        return ans;
    }
}