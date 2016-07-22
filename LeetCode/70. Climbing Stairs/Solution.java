public class Solution {
    //Fibonacci
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int pre = 1, cur = 1;
        for (int i = 0; i < n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return pre;
    }
}