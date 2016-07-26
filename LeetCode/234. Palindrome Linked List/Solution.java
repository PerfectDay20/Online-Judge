/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {//reverse the first half then compare
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        ListNode dummy = new ListNode(0), next = dummy.next;
        cur = head;
        int count = 0;
        while (count < length / 2) {
            dummy.next = cur;
            cur = cur.next;
            dummy.next.next = next;
            next = dummy.next;
            count++;
        }
        if (length % 2 == 1) {//delete the mid one if length is odd
            cur = cur.next;
        }
        while (cur != null) {
            if (cur.val != next.val) {
                return false;
            }
            cur = cur.next;
            next = next.next;
        }
        return true;

    }
}