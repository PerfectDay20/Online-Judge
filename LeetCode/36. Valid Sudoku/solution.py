class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        return self.test(board, lambda i, j: board[i][j]) \
               and self.test(board, lambda i, j: board[j][i]) \
               and self.test(board, lambda i, j: board[i // 3 * 3 + j // 3][j % 3 + i % 3 * 3])

    def test(self, board, getter):
        for i in range(9):
            mark = 0
            for j in range(9):
                s = getter(i, j)
                if s != '.':
                    if mark & (1 << int(s)) != 0:
                        return False
                    else:
                        mark |= 1 << int(s)
        return True
