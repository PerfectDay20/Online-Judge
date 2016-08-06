import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, ans, 0, sum, list);
        return ans;
    }

    private void helper(TreeNode root, List<List<Integer>> ans, int k, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (k + root.val == sum) {
                ans.add(new ArrayList<Integer>(list));
            }
        } else {
            k += root.val;
            helper(root.left, ans, k, sum, list);
            helper(root.right, ans, k, sum, list);
            k -= root.val;
        }
        list.remove(list.size() - 1);
    }
}