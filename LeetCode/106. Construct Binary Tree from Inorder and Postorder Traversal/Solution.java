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
        int[] post = {7, 4, 2, 5, 8, 6, 3, 1};
        TreeNode root = new Solution().buildTree(in, post);
        new Solution().tranverse(root);

    }

    public void tranverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            tranverse(root.left);
            tranverse(root.right);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] in, int il, int ir, int[] post, int pl, int pr) {
        if (il > ir) {
            return null;
        }
        int rootVal = post[pr];
        int i = il;
        while (in[i] != rootVal) {
            i++;
        }
        int length = i - il;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(in, il, i - 1, post, pl, pl + length - 1);
        root.right = buildTree(in, i + 1, ir, post, pl + length, pr - 1);
        return root;
    }

}