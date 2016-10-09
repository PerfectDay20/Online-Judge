import java.util.Arrays;
import java.util.Random;

public class Solution {
    private int[] origin;
    private Random random;

    public Solution(int[] nums) {
        origin = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = origin.length;
        int[] nums = Arrays.copyOf(origin, n);
        for (int i = 1; i < n; i++) {
            int t = random.nextInt(i + 1);
            if (t != i) {
                int temp = nums[i];
                nums[i] = nums[t];
                nums[t] = temp;
            }
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */