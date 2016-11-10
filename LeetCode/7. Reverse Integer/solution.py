class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        pos = x > 0
        s = int(str(abs(x))[::-1])
        if pos:
            if s > 2147483647:
                return 0
            else:
                return s
        else:
            if s > 2147483648:
                return 0
            else:
                return -s


so = Solution()
print(so.reverse(199000))
