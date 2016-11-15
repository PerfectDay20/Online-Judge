# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not (head and head.next):
            return head
        tail = head.next.next
        newhead = head.next
        newhead.next = head
        head.next = self.swapPairs(tail)
        return newhead

    def swapPairs1(self, head):
        dummy = ListNode(0)
        dummy.next, cur = head, dummy
        while cur.next and cur.next.next:
            a, b = cur.next, cur.next.next
            a.next, b.next, cur.next, cur = b.next, a, b, a
        return dummy.next



