# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next, cur, last = head, dummy, head
        while last:
            cur.next = last
            if last.val != val:
                cur = last
            last = last.next
        cur.next = last
        return dummy.next

