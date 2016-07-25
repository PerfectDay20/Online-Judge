import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack1 {
    Deque<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack1() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);//push the last min
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int n = stack.pop();
        if (n == min) {
            min = stack.pop();//when you pop the value == min, you get the last min
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */