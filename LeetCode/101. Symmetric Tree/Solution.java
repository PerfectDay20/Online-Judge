import java.util.Deque;
import java.util.LinkedList;

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
    public boolean isSymmetric(TreeNode root) {
        return root == null || solve(root.left, root.right);
    }

    //recursive
    private boolean solve(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == null && r == null;
        }
        return l.val == r.val && solve(l.left, r.right) && solve(l.right, r.left);
    }

    //iterative
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
        while (!list.isEmpty()) {
            TreeNode t1 = list.removeFirst();
            TreeNode t2 = list.removeFirst();
            if (t1 == null || t2 == null) {
                if (t1 != null || t2 != null) {
                    return false;
                }
            } else {
                if (t1.val != t2.val) {
                    return false;
                }
                list.add(t1.left);
                list.add(t2.right);
                list.add(t1.right);
                list.add(t2.left);
            }
        }
        return true;
    }
}