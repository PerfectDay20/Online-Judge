import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        ans[index++] = queue.peekFirst();
        for (int i = k; i < n; i++) {
            if (nums[i - k] == queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.add(nums[i]);
            ans[index++] = queue.peekFirst();
        }
        return ans;
    }
}