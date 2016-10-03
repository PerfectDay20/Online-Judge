public class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int prev = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            prev += i * A[i];
            sum += A[i];
        }
        int max = prev;
        for (int i = 1; i < n; i++) {
            prev = prev + sum - n * A[n - i];
            max = Math.max(prev, max);
        }
        return max;
    }
}