import java.util.*;

public class Solution {
    private Deque<TreeNode> stack;
    private TreeNode temp;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        temp = stack.pop();
        TreeNode ans = temp;
        temp = temp.right;
        while (temp!= null) {
            stack.push(temp);
            temp = temp.left;
        }
        return ans.val;
    }
}