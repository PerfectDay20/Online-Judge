public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {//p --> l --> r --> a -->
            ListNode l = p.next;
            ListNode r = l.next;
            ListNode a = r.next;
            p.next = r;
            r.next = l;
            l.next = a;
            p = l;
        }
        return dummy.next;
    }
}