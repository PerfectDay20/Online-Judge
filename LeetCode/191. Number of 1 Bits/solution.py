from collections import Counter


class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        return Counter(bin(n)[2:]).get('1') if n else 0

    def hammingWeight1(self, n):
        ans = 0
        while n:
            ans += n % 2
            n //= 2
        return ans

    def hammingWeight2(self, n):
        return bin(n).count('1')



