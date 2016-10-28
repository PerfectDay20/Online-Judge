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
    private int count, sum;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        traverse(root);
        return count;
    }

    private void traverse(TreeNode root) {
        if (root != null) {
            traverse(root, 0);
            traverse(root.left);
            traverse(root.right);
        }
    }

    private void traverse(TreeNode node, int temp) {
        if (node == null) {
            return;
        }
        temp += node.val;
        if (temp == sum) {
            count++;
        }
        traverse(node.left, temp);
        traverse(node.right, temp);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
//        root.right.right.right = new TreeNode(4);
//        root.right.right.right.right = new TreeNode(5);
        System.out.println(new Solution().pathSum(root, 3));
    }
}