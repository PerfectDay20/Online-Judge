from functools import reduce


class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = 0
        for c in s:
            ans = ans * 26 + ord(c) - ord('A') + 1
        return ans

    def titleToNumber1(self, s):
        return reduce(lambda x, y: 26 * x + y, map(lambda x: ord(x) - ord('A') + 1, s))

    def titleToNumber2(self, s):
        return reduce(lambda x, y: 26 * x + ord(y) - ord('A') + 1, s, 0)
