/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 0, lengthB = 0;
        ListNode curA = headA, curB = headB;
        while (curA.next != null) {
            curA = curA.next;
            lengthA++;
        }
        while (curB.next != null) {
            curB = curB.next;
            lengthB++;
        }
        if (curA != curB) {
            return null;
        }
        int gap = lengthA - lengthB;
        curA = headA;
        curB = headB;
        if (gap > 0) {
            for (int i = 0; i < gap; i++) {
                curA = curA.next;
            }
        } else {
            gap = -gap;
            for (int i = 0; i < gap; i++) {
                curB = curB.next;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}