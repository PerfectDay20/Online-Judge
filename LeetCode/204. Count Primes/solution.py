class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2: return 0
        ans = [True] * n
        ans[0] = ans[1] = False
        for i in range(2, int(n ** 0.5) + 1):
            if ans[i]:
                for j in range(i * i, n, i):
                    ans[j] = False
        return sum(ans)
