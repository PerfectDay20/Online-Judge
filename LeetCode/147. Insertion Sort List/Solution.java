/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;//use this dummy head create a new list
        while (cur != null) {
            while (pre.next != null && pre.next.val <= cur.val) {//find the location of the new item
                pre = pre.next;
            }
            ListNode temp = pre.next;
            pre.next = cur;
            cur = cur.next;
            pre.next.next = temp;
            pre = dummy;
        }
        return dummy.next;
    }
}