# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return False
        slow, fast = head.next, head.next.next
        while fast:
            if slow is fast:
                return True
            slow = slow.next
            if not fast.next or not fast.next.next:
                return False
            fast = fast.next.next
        return False

    def hasCycle(self, head):
        try:
            slow, fast = head.next, head.next.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except Exception:
            return False
