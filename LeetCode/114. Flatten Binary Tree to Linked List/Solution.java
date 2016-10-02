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

    private TreeNode prev = null;

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten1(root.right);
        flatten1(root.left);
        root.right = prev;
        root.left = null;
        prev = root; 
    }
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(list, root);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
        }
        list = null;
    }

    private void preOrder(List<TreeNode> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(list, root.left);
        preOrder(list, root.right);
        root.left = null;
        root.right = null;
    }

}