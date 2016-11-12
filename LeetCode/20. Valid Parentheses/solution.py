from collections import deque


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = deque()
        left, right = '([{', ')]}'
        for ch in s:
            if ch in left:
                stack.append(ch)
            else:
                index = right.index(ch)
                if not stack or stack[-1] != left[index]:
                    return False
                else:
                    stack.pop()
                    
        return len(stack) == 0
