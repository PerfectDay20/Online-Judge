/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode newOne = new RandomListNode(cur.label);
            cur.next = newOne;
            newOne.next = next;
            cur = next;
        }

        cur = head;
        while (cur!= null) {
            RandomListNode next = cur.next;
            next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode newHead = cur == null ? null : cur.next;
        RandomListNode p = newHead;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (cur != null) {
                p.next = p.next.next;
                p = p.next;
            }
        }
        return newHead;
    }
}