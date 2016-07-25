public class Solution {//Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        if (n < 2) {
            return 0;
        }
        notPrime[0] = notPrime[1] = true;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        int count = 0;
        for (boolean b : notPrime) {
            if (!b) {
                count++;
            }
        }
        return count;
    }
}