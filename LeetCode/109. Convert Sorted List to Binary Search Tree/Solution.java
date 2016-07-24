/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        Solution.head = head;
        return solve(0, n - 1);
    }
    private static ListNode head;
    private TreeNode solve(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >>> 1;
        TreeNode left = solve(l, mid - 1);
        TreeNode p = new TreeNode(head.val);
        head = head.next;
        TreeNode right = solve(mid + 1, r);
        p.left = left;
        p.right = right;
        return p;
    }
}