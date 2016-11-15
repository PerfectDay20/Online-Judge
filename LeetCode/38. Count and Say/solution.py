import itertools


class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = '1'
        for _ in range(n - 1):
            s = self.count(s)
        return s

    def count(self, s):
        ans, c = '', 1
        for i in range(len(s)):
            if i == len(s) - 1 or s[i] != s[i + 1]:
                ans += str(c) + s[i]
                c = 1
            else:
                c += 1
        return ans

    def countAndSay1(self, n):
        s = '1'
        for _ in range(n - 1):
            s = ''.join(str(len(list(group))) + key for (key, group) in itertools.groupby(s))
        return s

