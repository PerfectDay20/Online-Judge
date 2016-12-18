class Solution(object):
    def numberOfBoomerangs(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """

        count, counter = 0, {}
        for p1 in points:
            for p2 in points:
                if p1 == p2:
                    continue
                dx, dy = p1[0] - p2[0], p1[1] - p2[1]
                distance = dx * dx + dy * dy
                counter[distance] = counter.get(distance, 0) + 1
            for v in counter.values():
                count += v * (v - 1)
            counter.clear()
        return count

    def numberOfBoomerangs1(self, points):
        count, counter = 0, {}
        for p1 in points:
            for p2 in points:
                dx, dy = p1[0] - p2[0], p1[1] - p2[1]
                distance = dx * dx + dy * dy
                counter[distance] = counter.get(distance, 0) + 1
                count += 2 * (counter[distance] - 1)
            counter.clear()
        return count
