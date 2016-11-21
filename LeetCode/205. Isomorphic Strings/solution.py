class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        map1, map2 = {}, {}
        for (i, a), b in zip(enumerate(s), t):
            if map1.get(a, -1) != map2.get(b, -1):
                return False
            map1[a] = map2[b] = i
        return True

    def isIsomorphic1(self, s, t):
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))
