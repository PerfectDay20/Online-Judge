import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(s.nthUglyNumber(i + 1));
        }
    }


    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            nums[i] = min;
            if (min == factor2) {
                factor2 = 2 * nums[++index2];
            }
            if (min == factor3) {
                factor3 = 3 * nums[++index3];
            }
            if (min == factor5) {
                factor5 = 5 * nums[++index5];
            }
        }
        return nums[n - 1];
    }
}