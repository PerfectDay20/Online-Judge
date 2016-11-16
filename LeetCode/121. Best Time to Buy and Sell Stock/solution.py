class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        buy, ans = prices[0], 0
        for i in prices:
            ans = max(ans, i - buy)
            buy = min(buy, i)
        return ans
