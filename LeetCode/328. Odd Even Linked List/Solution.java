/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, cur = even.next;
        ListNode evenHead = even;
        while (true) {
            if (cur != null) {
                odd.next = cur;
                cur = cur.next;
                odd = odd.next;
            } else {
                break;
            }
            if (cur != null) {
                even.next = cur;
                cur = cur.next;
                even = even.next;
            } else {
                break;
            }
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}