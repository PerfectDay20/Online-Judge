class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1 = [int(v) for v in version1.split('.')]
        v2 = [int(v) for v in version2.split('.')]
        for i, j in zip(v1, v2):
            if i > j:
                return 1
            elif i < j:
                return -1
        l1, l2 = len(v1), len(v2)
        if l1 == l2:
            return 0
        elif l1 > l2:
            return 1 if sum(v1[l2:]) > 0 else 0
        else:
            return -1 if sum(v2[l1:]) > 0 else 0

    def compareVersion1(self, version1, version2):
        v1, v2 = (map(int, v.split('.')) for v in (version1, version2))
        diff = len(v2) - len(v1)
        v1, v2 = v1 + diff * [0], v2 + [0] * -diff
        if v1 > v2: return 1
        elif v1 < v2: return -1
        return 0