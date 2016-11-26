# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        left, right = min(p.val, q.val), max(p.val, q.val)
        while root.val < left or root.val > right:
            if root.val < left:
                root = root.right
            else:
                root = root.left
        return root