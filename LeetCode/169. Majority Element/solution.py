from collections import Counter


class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return sorted(nums)[len(nums) // 2]

    def majorityElement1(self, nums):
        c = Counter(nums)
        return c.most_common(1)[0][0]

    def majorityElement2(self, nums):
        t = n = 0
        for i in nums:
            if n == 0:
                t, n = i, 1
            elif t == i:
                n += 1
            else:
                n -= 1
        return t
