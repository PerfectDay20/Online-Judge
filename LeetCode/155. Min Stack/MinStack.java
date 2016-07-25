import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack2.isEmpty()||x<= stack2.peek()) {
            stack2.push(x);
        }
        stack1.push(x);
    }

    public void pop() {
        int n = stack1.pop();
        if (n == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
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