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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (++count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
    }

    public int kthSmallest1(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount >= k) {
            return kthSmallest1(root.left, k);
        } else if (leftCount < k - 1) {
            return kthSmallest1(root.right, k - leftCount - 1);
        } else {
            return root.val;
        }
    }

    private int count(TreeNode root) {
        return root == null ? 0 : 1 + count(root.left) + count(root.right);
    }
}