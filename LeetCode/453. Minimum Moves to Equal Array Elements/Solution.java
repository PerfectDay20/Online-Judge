public class Solution {
    public int minMoves(int[] nums) {
        long sum = 0, min = Integer.MAX_VALUE, n = nums.length;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, i);
        }
        return (int) (sum - n * min);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().minMoves(nums));

    }
}