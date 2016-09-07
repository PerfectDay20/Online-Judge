public class Solution {
    public int trap(int[] height) {//O(n) space O(n) time
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n], right = new int[n];
        left[0] = height[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

    public int trap1(int[] height) {//O(1) space O(n) time
        int left = 0, right = height.length - 1, sum = 0, leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}