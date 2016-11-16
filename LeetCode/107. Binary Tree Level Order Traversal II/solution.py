# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans, level = [], [root]
        while root and level:
            ans.append([n.val for n in level])
            next_level = [(n.left, n.right) for n in level]
            level = [leaf for LR in next_level for leaf in LR if leaf]
        return ans[::-1]