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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return getTree(1, n);
    }

    private List<TreeNode> getTree(int s, int e) {
        List<TreeNode> list = new ArrayList<>();
        if (s > e) {
            list.add(null);
        }
        for(int i = s; i <= e; i++) {
            List<TreeNode> l = getTree(s, i - 1);
            List<TreeNode> r = getTree(i + 1, e);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode t = new TreeNode(i);
                    t.left = left;
                    t.right = right;
                    list.add(t);
                }
            }
        }
        return list;
    }
}