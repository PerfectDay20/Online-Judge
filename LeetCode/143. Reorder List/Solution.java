/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new Solution().reorderList(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
    public void reorderList(ListNode head) {
        int n = getLength(head);
        if (n == 0) {
            return;
        }
        ListNode rightHead = getRightHalf(head, n);
        rightHead = reverse1(rightHead);
        merge(head, rightHead);
    }

    private int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        return n;
    }

    private ListNode getRightHalf(ListNode head, int length) {
        int n = (length + 1) / 2 - 1;
        while (n-- > 0) {
            head = head.next;
        }
        ListNode node = head.next;
        head.next = null;
        return node;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head.next, nh = reverse(p);
        head.next = null;
        p.next = head;
        return nh;
    }

    private ListNode reverse1(ListNode head) {
        ListNode pre = null, cur = head, post = null;
        while (cur!= null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

    private void merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (r != null) {
            cur.next = l;
            l = l.next;
            cur = cur.next;
            cur.next = r;
            r = r.next;
            cur = cur.next;
        }
        if (l != null) {
            cur.next = l;
        }
    }
}