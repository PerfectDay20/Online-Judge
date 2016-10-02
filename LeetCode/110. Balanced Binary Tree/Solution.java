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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = getHeight(root.right);
        if (rh == -1) {
            return -1;
        }
        return Math.abs(lh - rh) > 1 ? -1 : Math.max(lh, rh) + 1;
    }
}