class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        ss = [''] * numRows
        cycle = 2 * numRows - 2
        for idx, ch in enumerate(s):
            idx %= cycle
            if idx < numRows:
                ss[idx] += ch
            else:
                ss[cycle - idx] += ch
        return ''.join(ss)


so = Solution()
print(so.convert("A", 2))
