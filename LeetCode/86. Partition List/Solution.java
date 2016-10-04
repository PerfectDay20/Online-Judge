/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0), larger = new ListNode(0), s = smaller, l = larger;
        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                l.next = head;
                l = l.next;
            }
            head = head.next;
        }
        s.next = larger.next;
        l.next = null;
        return smaller.next;
    }
}