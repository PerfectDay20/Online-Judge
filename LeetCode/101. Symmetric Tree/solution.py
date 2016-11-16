# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def isSame(a, b):
            if a and b:
                return a.val == b.val and isSame(a.left, b.right) and isSame(a.right, b.left)
            return a is b

        return isSame(root, root)
