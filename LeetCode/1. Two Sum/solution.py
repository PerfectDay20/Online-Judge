class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = dict()
        for k, v in enumerate(nums):
            if target - v in d:
                return [d.get(target-v), k]
            else:
                d[v] = k


s = Solution()
print(s.twoSum([3, 2, 4], 6))
