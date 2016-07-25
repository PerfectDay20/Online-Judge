import java.util.*;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();//pop up the top one and add to the list
            list.add(temp.val);
            if (temp.right != null) {//first push the right
                stack.push(temp.right);
            }
            if (temp.left != null) {//then push the second, then it will pop up first
                stack.push(temp.left);
            }
        }
        return list;
    }
}