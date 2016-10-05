public class Solution {
    public double myPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 != 0) {
            if (n > 0) {
                return temp * temp * x;
            } else {
                return temp * temp / x;
            }
        } else {
            return temp * temp;
        }
    }
}