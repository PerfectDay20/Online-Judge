class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        if len(str) == 0:
            return 0
        ls = list(str.strip())

        sign = -1 if ls[0] == '-' else 1
        if ls[0] in '+-':
            del ls[0]

        size, i, ans = len(ls), 0, 0
        while i < size and ls[i].isdigit():
            ans = ans * 10 + ord(ls[i]) - ord('0')
            i += 1
        return max(-2 ** 31, min(2 ** 31 - 1, sign * ans))
   