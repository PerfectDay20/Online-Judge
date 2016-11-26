class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t): return False
        d = {}
        for i in s:
            d[i] = d.get(i, 0) + 1
        for i in t:
            if i not in d or d[i] == 0:
                return False
            d[i] -= 1
        return True
