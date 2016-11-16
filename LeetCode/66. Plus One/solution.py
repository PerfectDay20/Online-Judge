class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        i = len(digits) - 1
        digits[i] += 1
        while digits[i] == 10:
            digits[i] = 0
            i -= 1
            if i >= 0:
                digits[i] += 1
            else:
                break
        if digits[0] == 0:
            digits.insert(0, 1)
        return digits

    def plusOne1(self, digits):
        num = 0
        for i in digits:
            num = num * 10 + i
        return [int(d) for d in str(num + 1)]
