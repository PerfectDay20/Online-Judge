class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """

        def process(t):
            ans = 0
            while t:
                ans += (t % 10) ** 2
                t /= 10
            return ans

        s = set()
        while n not in s:
            s.add(n)
            if n == 1:
                return True
            n = process(n)

        return False
