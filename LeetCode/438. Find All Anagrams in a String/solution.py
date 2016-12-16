from collections import Counter


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        pCounter, sCounter, ans = Counter(p), Counter(s[:len(p) - 1]), []
        for i in range(len(p) - 1, len(s)):
            sCounter[s[i]] += 1
            left = i - len(p) + 1
            if sCounter == pCounter:
                ans.append(left)
            sCounter[s[left]] -= 1
            if sCounter[s[left]] == 0:
                del sCounter[s[left]]
        return ans