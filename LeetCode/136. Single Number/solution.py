from functools import reduce


class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        for i in nums:
            ans ^= i
        return ans

    def singleNumber1(self, nums):
        return reduce(lambda x, y: x ^ y, nums)
