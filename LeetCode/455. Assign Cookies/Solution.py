class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        i = j = count = 0
        gLength, sLength = len(g), len(s)
        while i < gLength and j < sLength:
            if g[i] <= s[j]:
                i, j, count = i + 1, j + 1, count + 1
            else:
                j += 1
        return count
