# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        def traverse(lists, node, level):
            if len(lists) == level:
                lists.append([])
            lists[level].append(node.val)
            if node.left:
                traverse(lists, node.left, level + 1)
            if node.right:
                traverse(lists, node.right, level + 1)

        ans = []
        if root: traverse(ans, root, 0)
        return ans

    def levelOrder1(self, root):
        ans, level = [], [root]
        while root and level:
            ans.append([n.val for n in level])
            next_level = [(n.left, n.right) for n in level]
            level = [leaf for LR in next_level for leaf in LR if leaf]
        return ans