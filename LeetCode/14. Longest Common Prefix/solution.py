class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs, s = sorted(strs), ''
        if not strs:
            return s

        for i, j in zip(strs[0], strs[-1]):
            if i == j:
                s += i
            else:
                break
        return s

