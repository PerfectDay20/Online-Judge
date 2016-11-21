class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        map = {}
        for i, a in enumerate(nums):
            if i - map.get(a, -k - 1) <= k:
                return True
            map[a] = i
        return False
