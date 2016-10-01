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
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = new Solution().buildTree(pre, in);
        new Solution().tranverse(root);

    }

    public void tranverse(TreeNode root) {
        if (root != null) {
            tranverse(root.left);
            tranverse(root.right);
            System.out.println(root.val);

        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        int rootVal = pre[pl];
        int i = il;
        while (in[i] != rootVal) {
            i++;
        }
        int length = i - il;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, pl + 1, pl + length, in, il, i - 1);
        root.right = buildTree(pre, pl + length + 1, pr, in, i + 1, ir);
        return root;
    }
}