class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        l1, l2 = len(haystack), len(needle)
        for i in range(l1 + 1):
            for j in range(l2 + 1):
                if j == l2:
                    return i
                elif i + j == l1:
                    return -1
                elif haystack[i + j] != needle[j]:
                    break
