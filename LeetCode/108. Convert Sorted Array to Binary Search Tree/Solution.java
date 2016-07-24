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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length - 1);
    }

    private TreeNode getNode(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getNode(nums, left, mid - 1);
        root.right = getNode(nums, mid + 1, right);
        return root;
    }

}