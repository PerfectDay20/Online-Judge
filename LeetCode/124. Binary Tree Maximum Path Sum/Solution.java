public class Solution {
    public int maxPathSum(TreeNode root) {
        return check(root)[2];
    }

    private int[] check(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, Integer.MIN_VALUE};
        }
        int[] l = check(root.left);
        int[] r = check(root.right);
        int left = Math.max(root.val, root.val + Math.max(l[0], l[1]));
        int right = Math.max(root.val, root.val + Math.max(r[0], r[1]));
        int all = Math.max(left + right - root.val, Math.max(l[2], r[2]));
        return new int[]{left, right, all};
    }
}