from functools import reduce


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        temp = []
        while n:
            temp.append(n % 2)
            n //= 2

        temp += [0] * (32 - len(temp))
        ans = reduce(lambda x, y: x * 2 + y, temp, 0)
        return ans

    def reverseBits1(self, n):
        return int(bin(n)[2:].zfill(32)[::-1], 2)
