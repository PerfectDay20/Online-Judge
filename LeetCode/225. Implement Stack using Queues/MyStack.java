import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    int top;
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue1.size();
        if (size == 1) {//only one item, delete and done
            queue1.remove();
        } else {
            for (int i = 0; i < size - 2; i++) {
                queue2.add(queue1.remove());
            }//left two item
            top = queue1.remove();//one be the top
            queue2.add(top);
            queue1.remove();//the other one deleted
            swap();
        }
    }

    private void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}