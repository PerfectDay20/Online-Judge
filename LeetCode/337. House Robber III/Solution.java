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
    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] helper(TreeNode root) {
        int[] ans = new int[2];//ans[0] mean don't choose root, ans[1] means choose root
        if (root == null) {
            return ans;
        }
        int[] cand1 = helper(root.left);
        int[] cand2 = helper(root.right);

        ans[0] = Math.max(cand1[0], cand1[1]) + Math.max(cand2[0], cand2[1]);
        ans[1] = root.val + cand1[0] + cand2[0];
        return ans;
    }

    //too many overlapping
    /*public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cand1 = rob(root.left) + rob(root.right);
        int cand2 = root.val;
        if (root.left != null) {
            cand2 += rob(root.left.left);
            cand2 += rob(root.left.right);
        }
        if (root.right != null) {
            cand2 +=rob(root.right.left);
            cand2 +=rob(root.right.right);
        }
        return Math.max(cand1, cand2);
    }*/
}