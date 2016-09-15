import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        int last = 0;
        boolean isFirst = true;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (isFirst) {
                    last = root.val;
                    isFirst = false;
                } else {
                    if (root.val <= last) {
                        return false;
                    }
                    last = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }
}