public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(1000000000));

    }
    public int findNthDigit(int n) {
        long step = 9, nd = 1;
        while (n > step * nd) {
            n -= step * nd;
            step *= 10;
            nd++;
        }
        long num = (long) Math.pow(10, nd - 1) + (n - 1) / nd;
        long bitNum = nd - (n - 1) % nd - 1;
        for (int i = 0; i < bitNum; i++) {
            num /= 10;
        }
        return (int) (num % 10);
    }
}