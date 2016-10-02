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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelTraverse(root, ans, 0);
        reverseList(ans);
        return ans;
    }

    private void levelTraverse(TreeNode node, List<List<Integer>> ans, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() <= level) {
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        List<Integer> list = ans.get(level);
        list.add(node.val);
        levelTraverse(node.left, ans, level + 1);
        levelTraverse(node.right, ans, level + 1);
    }

    private void reverseList(List<List<Integer>> ans) {
        int n = ans.size();
        for (int i = 0; i < n / 2; i++) {
            List<Integer> temp = ans.get(i);
            ans.set(i, ans.get(n - 1 - i));
            ans.set(n - 1 - i, temp);
        }
    }
}