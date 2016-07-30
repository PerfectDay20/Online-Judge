public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int ta = a;
            a = a ^ b;
            b = (ta & b) << 1;
        }
        return a;
    }
}