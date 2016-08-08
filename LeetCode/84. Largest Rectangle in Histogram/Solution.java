import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.largestRectangleArea1(nums));
        System.out.println(s.largestRectangleArea(nums));
        System.out.println(s.largestRectangleArea2(nums));


    }

    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (deque.isEmpty() || h >= heights[deque.peekLast()]) {
                deque.addLast(i);
            } else {
                int top = deque.removeLast();
                max = Math.max(max, heights[top] * (deque.isEmpty() ? i : i - 1 - deque.peekLast()));
                i--;
            }
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] left = new int[n];//use left to record the left item that smaller than heights[i]
        int[] right = new int[n];//record the right item that smaller than height[i]
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[i - 1]) {
                left[i] = i - 1;
            }else {
                int j = i - 1;
                while (j != -1 && heights[j] >= heights[i]) {
                    j = left[j];
                }
                left[i] = j;
            }
        }

        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > heights[i + 1]) {
                right[i] = i + 1;
            }else {
                int j = i + 1;
                while (j != n && heights[j] >= heights[i]) {
                    j = right[j];
                }
                right[i] = j;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(heights[i] * (right[i] - left[i] - 1), max);
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {//brute force O(N2)
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(max, heights[i] * count);
        }
        return max;
    }
}

