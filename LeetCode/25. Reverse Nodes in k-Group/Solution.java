/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;
        ListNode cur = head;
        while (count > 0) {
            if (cur == null) {
                return head;
            }
            count--;
            cur = cur.next;
        }
        cur = reverseKGroup(cur, k);
        ListNode temp = null;
        for (int i = 0; i < k; i++) {
            temp = head.next;
            head.next = cur;
            cur = head;
            head = temp;
        }
        return cur;
    }
}