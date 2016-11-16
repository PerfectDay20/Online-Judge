# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def height(node):
            if not node:
                return 0
            if node.left and node.right:
                return min(height(node.left), height(node.right)) + 1
            if node.left:
                return height(node.left) + 1
            return height(node.right) + 1

        return height(root)
