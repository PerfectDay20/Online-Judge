public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, next = cur.next;
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
            } else {
                cur.next = next;
                cur = next;
                next = cur.next;
            }
        }
        cur.next = null;
        return head;
    }
}