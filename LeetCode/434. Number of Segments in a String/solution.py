class Solution(object):
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.split())

    def countSegments1(self, s):
        preSpace, count = True, 0
        for c in s:
            if not preSpace and c == ' ':
                preSpace = True
            elif preSpace and c != ' ':
                preSpace = False
                count += 1
        return count

    def countSegments2(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] != ' ' and (i == 0 or s[i - 1] == ' '):
                count += 1
        return count
