from math import log


class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans, pace = 0, 5
        while n >= pace:
            ans += n // pace
            pace *= 5
        return ans

    def trailingZeroes1(self, n):
        ans = 0
        while n:
            ans += n / 5
            n /= 5
        return ans
