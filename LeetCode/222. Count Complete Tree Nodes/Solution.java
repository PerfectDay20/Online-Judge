/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        int level = getLevel(root);
        if (getLevel(root.right) == level - 1) {
            return (1 << (level - 1)) + countNodes(root.right);
        } else {
            return (1 << (level - 2)) + countNodes(root.left);
        }
    }


    private int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }
}