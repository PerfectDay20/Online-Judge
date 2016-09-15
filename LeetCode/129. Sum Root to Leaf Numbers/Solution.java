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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(root));

    }
    private int[] sum = {0};
    public int sumNumbers(TreeNode root) {
        solve(sum, 0, root);
        return sum[0];
    }

    private void solve(int[] sum, int cur, TreeNode root) {
        if (root == null) {
            return;
        }
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += cur;
        }
        solve(sum, cur, root.left);
        solve(sum, cur, root.right);
    }
}