import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(new Solution().divide(sc.nextInt(), sc.nextInt()));

        }
    }
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPos = dividend < 0 == divisor < 0;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);

        long ans = 0;
        while (a >= b) {
            long step = 0, temp = a;
            while (temp >= b) {
                temp >>>= 1;
                step++;
            }
            ans += (1 << (step - 1));
            a -= (b << (step - 1));

        }
        return isPos ? (int)ans : (int)-ans;
    }
}