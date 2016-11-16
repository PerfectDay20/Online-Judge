class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        if numRows == 0:
            return ans
        ans.append([1])
        if numRows == 1:
            return ans
        for i in range(numRows - 1):
            temp = [1]
            for j in range(len(ans[i]) - 1):
                temp.append(ans[i][j] + ans[i][j + 1])
            temp.append(1)
            ans.append(temp)
        return ans

    def generate1(self, numRows):
        ans = []
        if numRows == 0:
            return ans
        ans.append([1])
        for _ in range(numRows - 1):
            temp1 = list(ans[-1])
            temp1.append(0)
            temp2 = temp1[::-1]
            ans.append([a + b for a, b in zip(temp1, temp2)])
        return ans

    def generate2(self, numRows):
        ans = []
        if numRows == 0:
            return ans
        ans.append([1])
        for _ in range(numRows - 1):
            last = ans[-1]
            ans.append([a + b for a, b in zip([0] + last, last + [0])])
        return ans
