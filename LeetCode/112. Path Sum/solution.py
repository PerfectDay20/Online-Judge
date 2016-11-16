# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        sums = set()

        def compute(node, temp):
            if not node:
                return
            temp += node.val
            if not node.left and not node.right:
                sums.add(temp)
                return
            if node.left:
                compute(node.left, temp)
            if node.right:
                compute(node.right, temp)

        compute(root, 0)
        return sum in sums

    def hasPathSum1(self, root, sum):
        if not root:
            return False
        if not root.left and not root.right and sum == root.val:
            return True
        sum -= root.val
        return self.hasPathSum1(root.left, sum) or self.hasPathSum1(root.right, sum())
