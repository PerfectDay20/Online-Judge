class Solution(object):
    def repeatedSubstringPattern(self, str):
        """
        :type str: str
        :rtype: bool
        """
        n = len(str)
        for i in range(1, n // 2 + 1):
            if n % i != 0:
                continue
            d = n // i
            for j in range(1, d):
                if str[0:i] != str[j * i:(j + 1) * i]:
                    break
            else:
                return True
        return False

    def repeatedSubstringPattern1(self, str):
        return str in (str+str)[1:-1]

