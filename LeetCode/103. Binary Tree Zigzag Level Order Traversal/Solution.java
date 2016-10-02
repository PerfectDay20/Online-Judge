import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        addNode(deque, root);
        boolean rightToLeft = false;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                addNode(deque, node.left);
                addNode(deque, node.right);
            }
            if (rightToLeft) {
                reverseList(list);
            }
            ans.add(list);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }

    private void reverseList(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(n - 1 - i));
            list.set(n - 1 - i, temp);
        }
    }

    private void addNode(Deque<TreeNode> deque, TreeNode node) {
        if (node != null) {
            deque.add(node);
        }
    }
}