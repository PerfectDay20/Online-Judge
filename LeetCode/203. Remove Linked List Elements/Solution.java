/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (pre.next.val != val) {
                pre = pre.next;
                cur = pre.next;
            } else {
                pre.next = cur.next;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}