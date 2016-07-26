/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {//recursive
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = null;
        ListNode newHead = reverseList(p);
        p.next = head;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {//iterative
        ListNode dummy = new ListNode(0);
        ListNode next = dummy.next;
        while (head != null) {
            ListNode temp = head.next;
            dummy.next = head;
            head.next = next;
            next = head;
            head = temp;
        }
        return dummy.next;
    }
}