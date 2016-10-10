import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int lastRemaining(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean leftToRight = false;
        while (n != 1) {
            stack.push(n);
            leftToRight = !leftToRight;
            n -= (n + 1) / 2;
        }
        while (!stack.isEmpty()) {
            int t = stack.pop();
            if (leftToRight) {
                n *= 2;
            } else {
                if ((t & 1) == 1) {
                    n *= 2;
                } else {
                    n = n * 2 - 1;
                }
            }
            leftToRight = !leftToRight;
        }
        return n;
    }
}