# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        left = right = head
        for i in range(n):
            right = right.next
        if not right:
            return left.next
        while right.next:
            left, right = left.next, right.next
        left.next = left.next.next
        return head