public class Solution {
    //https://en.wikipedia.org/wiki/Newton%27s_method
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}