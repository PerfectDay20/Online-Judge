/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = null, post = null;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        post = cur.next;
        ListNode leftTail = pre, midTail = cur;
        for (int i = 0; i < n - m; i++) {
            pre = cur;
            cur = post;
            post = post.next;
            cur.next = pre;
        }
        leftTail.next = cur;
        midTail.next = post;
        return dummy.next;
    }
}