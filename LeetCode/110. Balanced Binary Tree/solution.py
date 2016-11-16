# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def height(root):
            if not root:
                return 0
            lh = height(root.left)
            if lh == -1:
                return -1
            rh = height(root.right)
            if rh == -1:
                return -1
            if abs(lh - rh) > 1:
                return -1
            return max(lh, rh) + 1

        return height(root) != -1
